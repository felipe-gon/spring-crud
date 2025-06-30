const USERS_API = '/pessoas';
const CHECKIN_API = '/checkin';
const createUserForm = document.getElementById('create-user-form');
const newCheckinForm = document.getElementById('new-checkin-form');
const userList = document.getElementById('user-list');

// --- Funções de Gerenciamento de Hóspedes ---

async function fetchUsers() {
    try {
        const response = await fetch(`${USERS_API}/getUsers`);
        if (!response.ok) {
            throw new Error('Falha ao buscar usuários.');
        }
        const users = await response.json();
        renderUsers(users);
    } catch (error) {
        console.error('Erro:', error);
        userList.innerHTML = '<li>Erro ao carregar a lista de hóspedes.</li>';
    }
}

function renderUsers(users) {
    userList.innerHTML = ''; // Limpa a lista
    if (users.length === 0) {
        userList.innerHTML = '<li>Nenhum hóspede cadastrado.</li>';
        return;
    }
    users.forEach(user => {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <div class="user-info">
                <strong>${user.nome}</strong><br>
                <small>Documento: ${user.documento} | Telefone: ${user.telefone}</small>
            </div>
            <button class="delete-btn" data-id="${user.id}">Remover</button>
        `;
        userList.appendChild(listItem);
    });
}

async function handleCreateUser(event) {
    event.preventDefault();
    const nome = document.getElementById('user-name').value.trim();
    const documento = document.getElementById('user-doc').value.trim();
    const telefone = document.getElementById('user-phone').value.trim();

    if (!nome || !documento || !telefone) {
        alert('Todos os campos são obrigatórios.');
        return;
    }

    const newUser = { nome, documento, telefone };

    try {
        const response = await fetch(`${USERS_API}/createUser`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newUser),
        });

        const resultText = await response.text();

        if (!response.ok) {
            throw new Error(resultText || 'Falha ao criar usuário.');
        }

        alert(resultText);
        createUserForm.reset();
        fetchUsers(); // Atualiza a lista de usuários

    } catch (error) {
        console.error('Erro:', error);
        alert(`Erro ao criar usuário: ${error.message}`);
    }
}

async function handleDeleteUser(event) {
    if (!event.target.classList.contains('delete-btn')) return;

    const userId = event.target.dataset.id;
    if (!confirm(`Tem certeza que deseja remover o hóspede com ID ${userId}?`)) {
        return;
    }

    try {
        const response = await fetch(`${USERS_API}/deleteUser`, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ id: userId }),
        });

        const resultText = await response.text();

        if (!response.ok) {
            throw new Error(resultText || 'Falha ao deletar usuário.');
        }

        alert(resultText);
        fetchUsers(); // Atualiza a lista

    } catch (error) {
        console.error('Erro:', error);
        alert(`Erro ao remover hóspede: ${error.message}`);
    }
}

// --- Funções de Gerenciamento de Check-in ---

async function handleNewCheckin(event) {
    event.preventDefault();
    const guestName = document.getElementById('checkin-guest-name').value.trim();
    const hasVehicle = document.getElementById('checkin-has-vehicle').checked;
    const dataEntrada = document.getElementById('checkin-data-entrada').value;
    const dataSaida = document.getElementById('checkin-data-saida').value;

    if (!guestName || !dataEntrada || !dataSaida) {
        alert('O nome do hóspede, data de entrada e saída são obrigatórios.');
        return;
    }

    const checkinData = {
        pessoa: {
            nome: guestName
        },
        adicionalVeiculo: hasVehicle,
        dataEntrada: dataEntrada,
        dataSaida: dataSaida
    };

    try {
        const response = await fetch(`${CHECKIN_API}/newCheckin`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(checkinData),
        });

        if (!response.ok) {
            if (response.status === 404) {
                throw new Error('Hóspede não encontrado. Cadastre o hóspede antes de fazer o check-in.');
            }
            // Tenta ler o erro como JSON, que tem mais detalhes
            const errorDetails = await response.json();
            throw new Error(errorDetails.message || 'Falha ao realizar check-in.');
        }

        const resultText = await response.text();
        alert(resultText);
        newCheckinForm.reset();

    } catch (error) {
        console.error('Erro:', error);
        alert(`Erro ao fazer check-in: ${error.message}`);
    }
}

document.addEventListener('DOMContentLoaded', fetchUsers);
createUserForm.addEventListener('submit', handleCreateUser);
userList.addEventListener('click', handleDeleteUser);
newCheckinForm.addEventListener('submit', handleNewCheckin);