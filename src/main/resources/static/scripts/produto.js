// Chave da API sendo instanciada como CONST par que não seja alterada
const API_Get_Produtos =
    "/produtos";

document.addEventListener("DOMContentLoaded", carregarProdutos);

async function carregarProdutos() {

    try {

        const resposta = await fetch(API_Get_Produtos);

        if (!resposta.ok) {
            throw new Error("Erro ao buscar produtos");
        }

        const produtos = await resposta.json();

        const listaProdutos =
            document.getElementById("listaProdutos");

        listaProdutos.innerHTML = "";

        produtos.forEach(produto => {

            const linha =
                document.createElement("div");

            linha.classList.add("linhaProduto");

            linha.innerHTML = `
                <div>${produto.nomeProduto ?? ""}</div>
                <div>${produto.quantidadeProduto ?? 0}</div>
                <div>R$ ${produto.precoProduto ?? 0}</div>
            `;

            listaProdutos.appendChild(linha);

        });

    } catch (erro) {

        console.error("Erro ao carregar produtos:", erro);

        alert("Não foi possível carregar os produtos.");

    }

}