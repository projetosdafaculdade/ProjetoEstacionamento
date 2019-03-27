drop database estacionamento;
create database estacionamento;
use estacionamento;

    create table cliente(
    idCliente int not null primary key auto_increment,
	condutor varchar(45),
	tipoCliente boolean,
	valorPagoCliente double,
    ativado int default 1
    );
    
    create table ordemServico(
    idOrdemServico int not null primary key auto_increment,
    dataTimeEntrada long,
    dataTimeSaida long,
    valorServico double default 0,
    ativado int default 1
    );
    
    create table veiculo(
     idVeiculo int not null primary key auto_increment,
     placa varchar(45),
     cor varchar(45),
     modelo varchar(45),
     marca varchar(45),
    ativado int default 1
	);
    
    create table servicos(
    idServicos int not null primary key auto_increment,
    valorPublico double,
    valorServidor double,
    fracao int,
    ativado int default 1
    );
    
    create table clienteComVeiculos(
		idCliente INT NOT NULL,
		idVeiculo INT NOT NULL,
		PRIMARY KEY(IDVEICULO),
		FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente),
		FOREIGN KEY (idVeiculo) REFERENCES Veiculo (idVeiculo) 
    );
    
    create table OrdemServicoComClienteServico(
		idCliente INT NOT NULL,
		idServicos INT NOT NULL,
		idOrdemServico INT NOT NULL,
        idVeiculo INT NOT NULL,
		PRIMARY KEY(idCliente, idServicos, idOrdemServico),
        FOREIGN KEY (idCliente) REFERENCES cliente (idCliente),
		FOREIGN KEY (idServicos) REFERENCES servicos (idServicos),
		FOREIGN KEY (idOrdemServico) REFERENCES ordemServico (idOrdemServico),
        FOREIGN KEY (idVeiculo) REFERENCES veiculo (idVeiculo)
	);
    
    
    