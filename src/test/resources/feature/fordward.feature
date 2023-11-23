#language: pt

  Funcionalidade: Teste de funcionalidade de api ForwardCar usando MYSQL

    @CT001
    Cenario: Realizar cadastro na ForwardCar
      Dado que realizo o cadastro na plataforma da ForwardCar com massa de MySQL
      Entao sistema me retorna statusCode 200

    @CT002
    Cenario: Realizar cadastro na ForwardCar com usarname já existente
      Dado  que realizo o cadastro na plataforma da ForwardCar com massa de MySQL
      Quando que realizo o cadastro na plataforma da ForwardCar com username ja existente
      Entao sistema nao realiza cadastro e retorna statusCode 500

    @CT003
    Cenario: Realizar Login com usuário Cadastrado
      Dado que realizo login com usuario cadastrado
      Entao o sistema me retorna status code 200

    @CT004
    Cenario: Cadastrar novo modelo de Carro
      Dado que quero cadastrar um novo veículo e preencho os seguintes campos
      Entao sistema me retorna o VIN do modelo que cadastrei

    @CT005
    Cenario: Consultar se novo modelo está cadastrado na funcao get
      Dado que cadastrei um novo veiculo na ForwardCar
      Entao sistema me retorna VIN do carro cadastrado no GET