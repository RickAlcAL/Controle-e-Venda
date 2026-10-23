async function carregarPerfil() {
    try {
        const resposta = await fetch('/api/usuario');

        if (resposta.status === 401) {
            window.location.href = 'login.html';
            return;
        }

        if (!resposta.ok) {
            throw new Error('Erro ' + resposta.status);
        }

        const u = await resposta.json();
        const sobrenome = u.sobrenome || '';
        const nomeCompleto = (u.nome + ' ' + sobrenome).trim();

        document.getElementById('avatar').textContent = u.nome.charAt(0).toUpperCase();
        document.getElementById('perfil-nome-completo').textContent = nomeCompleto;
        document.getElementById('perfil-nome').textContent = u.nome;
        document.getElementById('perfil-sobrenome').textContent = sobrenome || '-';
        document.getElementById('perfil-telefone').textContent = u.telefone;
        document.getElementById('perfil-endereco').textContent = u.endereco;
        document.getElementById('perfil-numero').textContent = u.numero;
        document.getElementById('perfil-cep').textContent = u.cep;
        document.getElementById('perfil-cidade-estado').textContent = u.cidade + ' / ' + u.estado;
        document.getElementById('perfil-observacao').textContent = u.observacao || 'Nenhuma observação.';
    } catch (erro) {
        console.error('Falha ao carregar o perfil:', erro);
        document.getElementById('perfil-nome-completo').textContent = 'Erro ao carregar os dados';
    }
}

carregarPerfil();

