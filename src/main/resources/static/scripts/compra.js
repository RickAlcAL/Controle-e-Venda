const API_Get_Produtos =
    "/produtos";

const API_Post_Produtos = "/produtos/adicionarProduto";


document.addEventListener("DOMContentLoaded", () => {

    carregarProdutos();

    const formProduto =
        document.getElementById("formProduto");

    if (formProduto) {

        formProduto.addEventListener(
            "submit",
            cadastrarProduto
        );

    }

});


async function carregarProdutos() {

    const lista =
        document.getElementById("listaProdutos");

    if (!lista) {
        return;
    }


    try {

        const resposta =
            await fetch(API_Get_Produtos);

        if (!resposta.ok) {
            throw new Error("Erro ao buscar produtos");
        }

        const produtos =
            await resposta.json();


        lista.innerHTML = "";


        produtos.forEach(produto => {

            const item =
                document.createElement("li");

            item.textContent =
                `${produto.nomeProduto}
                - R$ ${produto.precoProduto}
                - Quantidade: ${produto.quantidadeProduto}
                - Fornecedor: ${produto.fornecedor?.nomeFornecedor ?? ""}`;

            lista.appendChild(item);

        });

    } catch (erro) {

        console.error(
            "Erro ao carregar produtos:",
            erro
        );

    }

}


async function cadastrarProduto(evento) {

    evento.preventDefault();


    const novoProduto = {

        nomeProduto:
            document.getElementById("nomeProduto").value,

        precoProduto:
            parseFloat(
                document.getElementById("precoProduto").value
            ),

        quantidadeProduto:
            parseInt(
                document.getElementById("quantidadeProduto").value
            ),

        fornecedor: {

            id:
                parseInt(
                    document.getElementById("fornecedor").value
                )

        }

    };


    try {

        const resposta =
            await fetch(API_Post_Produtos, {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body:
                    JSON.stringify(novoProduto)

            });


        if (!resposta.ok) {

            throw new Error(
                "Erro ao cadastrar produto"
            );

        }


        alert(
            "Produto cadastrado com sucesso!"
        );


        document
            .getElementById("formProduto")
            .reset();


        window.location.href =
            "index.html";


    } catch (erro) {

        console.error(erro);

        alert(
            "Erro ao cadastrar o produto. Tente novamente."
        );

    }

}