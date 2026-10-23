async function carregarPerfilFornecedor() {
    try {
        const resposta = await fetch('/api/fornecedor');

        if (resposta.status === 401) {
            window.location.href = 'login.html';
            return;
        }

        if (!resposta.ok) {
            throw new Error('Erro ' + resposta.status);
        }

        const f = await resposta.json();

        document.getElementById('avatar').textContent = f.nome.charAt(0).toUpperCase();
        document.getElementById('perfil-nome-completo').textContent = f.nome;
        document.getElementById('perfil-nome').textContent = f.nome;
        document.getElementById('perfil-cpf-cnpj').textContent = f.cpfOuCnpj;
        document.getElementById('perfil-telefone').textContent = f.telefone || '-';
        document.getElementById('perfil-email').textContent = f.email || '-';
        document.getElementById('perfil-endereco').textContent = f.endereco || '-';
    } catch (erro) {
        console.error('Falha ao carregar o perfil do fornecedor:', erro);
        document.getElementById('perfil-nome-completo').textContent = 'Erro ao carregar os dados';
    }
}

carregarPerfilFornecedor();