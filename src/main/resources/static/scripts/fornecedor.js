const API_Get_Fornecedores =
    "/fornecedores";


document.addEventListener("DOMContentLoaded", () => {

    carregarFornecedores();

    carregarFornecedoresSelect();

});


async function carregarFornecedores() {

    const listaFornecedor =
        document.getElementById("listaFornecedor");

    if (!listaFornecedor) {
        return;
    }


    try {

        const resposta =
            await fetch(API_Get_Fornecedores);

        if (!resposta.ok) {
            throw new Error("Erro ao buscar fornecedores");
        }

        const fornecedores =
            await resposta.json();


        listaFornecedor.innerHTML = "";


        fornecedores.forEach(fornecedor => {

            const linha =
                document.createElement("div");

            linha.classList.add("linhaFornecedor");


            linha.innerHTML = `
                <div>${fornecedor.nomeFornecedor ?? ""}</div>
                <div>${fornecedor.cpfOucnpjFornecedor ?? ""}</div>
                <div>${fornecedor.emailFornecedor ?? ""}</div>
                <div>${fornecedor.telefoneFornecedor ?? ""}</div>
                <div>${fornecedor.enderecoFornecedor ?? ""}</div>
            `;


            listaFornecedor.appendChild(linha);

        });

    } catch (erro) {

        console.error(
            "Erro ao carregar fornecedores:",
            erro
        );

    }

}


async function carregarFornecedoresSelect() {

    const selectFornecedor =
        document.getElementById("fornecedor");

    if (!selectFornecedor) {
        return;
    }


    try {

        const resposta =
            await fetch(API_Get_Fornecedores);

        if (!resposta.ok) {
            throw new Error("Erro ao buscar fornecedores");
        }

        const fornecedores =
            await resposta.json();


        selectFornecedor.innerHTML = `
            <option value="">
                Selecione um fornecedor
            </option>
        `;


        fornecedores.forEach(fornecedor => {

            const option =
                document.createElement("option");


            option.value =
                fornecedor.id;


            option.textContent =
                fornecedor.nomeFornecedor;


            selectFornecedor.appendChild(option);

        });

    } catch (erro) {

        console.error(
            "Erro ao carregar fornecedores no select:",
            erro
        );

    }

}