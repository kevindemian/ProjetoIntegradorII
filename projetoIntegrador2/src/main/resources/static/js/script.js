$(document).ready(function () {
  /*INÍCIO DA PÁGINA. DEIXA APENAS OS BOTÕES DE FUNÇÕES VISÍVEL*/
  $('#pesquisa').hide();
  $('#fld_EntradaProduto').hide();
  $('#fld_SaidaProduto').hide();
  $('#inp_nome_produto').attr('disabled', true);

  /**ÁREA DE FUNÇÕES PARA SEREM CHAMADAS*/

  //CALCULA TOTAL DE COMPRA OU VENDA
  function calculaTotal(qtd, prec) {
    let preco = prec.replace(',', '.');
    return Number(qtd * preco).toFixed(2);
  }

  //PREENCHE VALOR TOTAL DA VENDA
  function preencheTotalVenda() {
    let totalVenda = 0;
    let a = $('#quantidade_produto_venda').val();
    let b = $('#inp_preco_saida').val();
    if (a != '' && b != '') {
      totalVenda = calculaTotal(a, b);
      $('#total_venda').text(totalVenda);
    }
  }

  //PREENCHE VALOR TOTAL DA COMPRA
  function preencheTotalCompra() {
    let totalCompra = 0;
    let a = $('#inQtdEntrada').val();
    let b = $('#inPrecoEntrada').val();
    if (a != '' && b != '') {
      totalCompra = calculaTotal(a, b);
      $('#total_compra').text(totalCompra);
    }
  }

  /*AÇÃO AO CLICAR NO BOTÃO DE FUNÇÃO DE PESQUISA*/
  $('#botao_pesquisar').click(function () {
    $('#pesquisa').toggle();
    $('#tbl_estoque').hide();
    $('#fld_EntradaProduto').hide();
    $('#fld_SaidaProduto').hide();
  });

  /*SELECIONANDO OPÇÕES DE PESQUISA*/

  $('.radioButton').change(function () {
    let a = document.querySelector("input[name='tipo_pesquisa']:checked").value;

    //Pesquisa por ID
    if (a === 'id') {
      $('#inp_nome_produto').val('').attr('disabled', true);
      $('#inp_cod_produto').attr('disabled', false);
    }
    //Pesquisa por Nome
    else if (a === 'nome') {
      $('#inp_cod_produto').val('').attr('disabled', true);
      $('#inp_nome_produto').attr('disabled', false);
    }
  });

  /*AÇÃO AO CLICAR NO BOTÃO DE PESQUISAR*/

  $('#btn_pesquisa_produto').click(function () {
    let tipoDaPesquisa = document.querySelector(
      "input[name='tipo_pesquisa']:checked"
    ).value;
    let id = $('#inp_cod_produto').val();
    let nome = $('#inp_nome_produto').val();

    if (tipoDaPesquisa === 'id' && id > 0) {
      window.location = 'http://localhost:8080/pesquisaid?id=' + id;
    } else {
      window.location = 'http://localhost:8080/pesquisanome?nome=' + nome;
    }
  });

  /*AÇÃO AO CLICAR NO BOTÃO DE CADASTRAR ENTRADA*/
  $('#btn_CadastrarEntrada').click(function () {
    $('#fld_EntradaProduto').toggle();
    $('#tbl_estoque').hide();
    $('#pesquisa').hide();
    $('#fld_SaidaProduto').hide();
    let hoje = new Date();
    let dia = hoje.getDate();
    let mes = hoje.getMonth() + 1;
    let ano = hoje.getFullYear();
    let data = ano + '-' + mes + '-' + dia;
    $('#dataEntrada').val(data);
  });

  /*AÇÃO AO CLICAR NO BOTÃO DE CADASTRAR SAÍDA*/
  $('#btn_CadastrarSaida').click(function () {
    $('#fld_SaidaProduto').toggle();
    $('#tbl_estoque').hide();
    $('#pesquisa').hide();
    $('#fld_EntradaProduto').hide();
    let hoje = new Date();
    let dia = hoje.getDate();
    let mes = hoje.getMonth() + 1;
    let ano = hoje.getFullYear();
    let data = ano + '-' + mes + '-' + dia;
    $('#inp_data_saida').val(data);
  });

  /*AÇÃO AO CLICAR NO BOTÃO DE LOGOUT*/
  $('#btn_logout').click(function () {
    let resposta = confirm('Deseja deslogar do sistema?');
    if (resposta == true) {
      window.location = 'http://localhost:8080/logout';
    }
  });

  /*REQUESTS----------------------------------------------------------------*/

  //--GET ------

  //PREENCHE O FORMULÁRIO DE ENTRADA DE PRODUTOS
  function preencheCadastroEntradaProduto(id) {
    $.ajax({
      url: 'http://localhost:8080/pesquisa/produto/?id=' + id,
      method: 'GET',
      success: function (data) {
        let produto = data;

        if (produto != null && produto != '') {
          $('#inp_nome_entrada').val(produto.nome);
          $('#total_compra').val('');
          $('#inQtdEntrada').val('');
          $('#inPrecoEntrada').val('');
        } else {
          alert('Produto não encontrado');
          $('#inp_id_produto_entrada').val('');
          $('#inp_nome_entrada').val('');
          $('#inPrecoEntrada').val('');
          $('#inQtdEntrada').val('');
          $('#total_compra').val('');

          return;
        }
      },
      error: function () {
        alert('Produto não encontrado');
      },
    });
  }

  //FAZ AS CHAMADAS DINÂMICAS PARA PREENCHIMENTO DAS INFORMAÇÕES NO FORM DE ENTRADA

  $('#inp_id_produto_entrada').change(function () {
    let idProduto = $('#inp_id_produto_entrada').val();
    preencheCadastroEntradaProduto(idProduto);
  });

  $('#inQtdEntrada').change(function () {
    preencheTotalCompra();
  });

  $('#inPrecoEntrada').change(function () {
    preencheTotalCompra();
  });

  //PREENCHE O FORMULÁRIO DE SAÍDA DE PRODUTOS
  function preencheCadastroSaidaProduto(id) {
    $.ajax({
      url: 'http://localhost:8080/pesquisa/produto/?id=' + id,
      method: 'GET',
      success: function (data) {
        let produto = data;

        if (produto != null && produto != '') {
          $('#inp_nome_produto_saida').val(produto.nome);
          $('#inp_preco_saida').val(produto.precoVenda);
          $('#quantidade_produto_venda').val('');
          $('#total_venda').text('');
          $('#quantidade_produto_venda').attr('max', produto.quantidade);
        } else {
          alert('Produto não encontrado');
          $('#inp_nome_produto_saida').val('');
          $('#inp_preco_saida').val('');
          $('#quantidade_produto_venda').val('');
        }
      },
      error: function () {
        alert('Produto não encontrado');
      },
    });
  }

  //AÇÃO QUANDO OCORRE MUDANÇA DO VALOR DO CAMPO ID PRODUTO NO FORMULÁRIO DE SAÍDA DE PRODUTO
  $('#inp_id_produto_saida').change(function () {
    let idProduto = $('#inp_id_produto_saida').val();
    preencheCadastroSaidaProduto(idProduto);
  });

  //AÇÃO QUANDO OCORRE MUDANÇA DO VALOR DO CAMPO QTDE PRODUTO NO FORMULÁRIO DE SAÍDA DE PRODUTO
  $('#quantidade_produto_venda').change(function () {
    preencheTotalVenda();
  });

  //--------------------------------POST-------------------------------------------------

  //CADASTRAR COMPRA-------------------

  function cadastrarCompra(idFornecedor, produtoComprado) {
    $.ajax({
      url: 'http://localhost:8080/entradaproduto?id=' + idFornecedor,
      method: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(produtoComprado),
      success: function (data) {
        alert('Compra cadastrada com sucesso');
        window.location = 'http://localhost:8080/main';
      },
      error: function () {
        alert('Não foi possível cadastrar a compra.');
      },
    });
  }

  //------------------------------------------------------------------------------------

  // Recebe cadastro DA COMPRA
  $('#cadastro_prod').submit(function (event) {
    event.preventDefault();

    let produto;
    let idFornecedor = $('#fornecedor').val();
    let idProduto = $('#inp_id_produto_entrada').val();

    function getProdutoById(idProduto) {
      $.ajax({
        url: 'http://localhost:8080/pesquisa/produto/?id=' + idProduto,
        method: 'GET',
        async: false,
        success: function (data) {
          produto = data;
        },
        error: function () {
          alert('Produto não encontrado');
          $('#inp_id_produto_entrada').val('');
          $('#inPrecoEntrada').val('');
          $('#inQtdEntrada').val('');
        },
      });
    }

    getProdutoById(idProduto);

    let preco = $('#inPrecoEntrada').val().replace(',', '.');
    let quantidade = $('#inQtdEntrada').val();

    if (quantidade === '' || quantidade === 0) {
      alert('Por favor, informe a quantidade de produto');
      return;
    }

    let produtoComprado = {
      produtoComprado: produto,
      preco: preco,
      quantidade_comprada: quantidade,
    };

    cadastrarCompra(idFornecedor, produtoComprado);
  });

  //CADASTRAR VENDA

  function cadastrarVenda(id, produtoVendido) {
    $.ajax({
      url: 'http://localhost:8080/saidaproduto?id=' + id,
      method: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(produtoVendido),
      success: function (data) {
        alert('Venda cadastrada com sucesso');
        window.location = 'http://localhost:8080/main';
      },
      error: function () {
        alert('Não foi possível cadastrar a venda.');
      },
    });
  }

  // Recebe cadastro DA VENDA
  $('#cadastroSaidProd').submit(function (event) {
    event.preventDefault();

    let id = $('#inp_id_produto_saida').val();
    let preco = $('#inp_preco_saida').val();
    let quantidade = $('#quantidade_produto_venda').val();

    if (quantidade === '' || quantidade === 0) {
      alert('Por favor, informe a quantidade de produto');
      return;
    }

    let produtoVendido = {
      preco: preco,
      quantidade_vendida: quantidade,
    };

    cadastrarVenda(id, produtoVendido);
  });

  //--------------------------

  /*VALIDAÇÕES-------------------------------------------------------------*/

  let inputZ = document.getElementById('inQtdEntrada');
  inputZ.oninvalid = function (event) {
    event.target.setCustomValidity(
      'A quantidade de produtos deve ser de, no mínimo, 1'
    );
  };

  let inputA = document.getElementById('inPrecoEntrada');
  inputA.oninvalid = function (event) {
    event.target.setCustomValidity(
      'O preço informado deve ter o formato XX,XX e ser maior que 0'
    );
  };
});
