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
    dataEntrada date,
    horaEntrada time,
    dataSaida date,
    horaSaida time,
    valorServico double,
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
    valorHora double,
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
    
		idOrdemServicoComServicos INT AUTO_INCREMENT,
		idServicos INT NOT NULL,
		idOrdemServico INT NOT NULL,
		PRIMARY KEY(idOrdemServicoComServicos, idServicos, idOrdemServico),
		FOREIGN KEY (idServicos) REFERENCES servicos (idServicos),
		FOREIGN KEY (idOrdemServico) REFERENCES ordemServico (idOrdemServico) 
	);
    
        
    insert into ordemServico(valorServico,dataEntrada,horaEntrada, ativado) values (20,'2019-3-18','12:55:55',1);
    insert into veiculo(placa, cor, modelo, marca, ativado) values('QDS-2323','preto','toro','fiat', 1);
    insert into servicos(valorHora, fracao, ativado) values(20, 10, 1);
	insert into cliente(condutor, tipoCliente, valorPagoCliente,ativado) values('Johnatan',true, 20,1);
    
    insert into clienteComVeiculos(idCliente, idVeiculo) values(1,1);
	insert into OrdemServicoComClienteServico(idCliente,idServicos,idOrdemServico,idVeiculo) values(1,1,1,1);
        
    insert into ordemServico(valorServico,dataEntrada,horaEntrada,ativado) values (20,'2019-3-18','12:55:55',1);
	insert into veiculo(placa, cor, modelo, marca, ativado) values('QXH-2326','preto','GOL','VK', 1);
    insert into servicos(valorHora, fracao, ativado) values(20, 10, 2);
	insert into cliente(condutor, tipoCliente, valorPagoCliente,ativado) values('Maria',true, 20,1);
        
    insert into clienteComVeiculos(idCliente, idVeiculo) values(2,2);
    insert into OrdemServicoComClienteServico(idCliente,idServicos,idOrdemServico,idVeiculo) values(2,2,2,2);
    
	insert into ordemServico(valorServico,dataEntrada,horaEntrada,ativado) values (20,'2019-3-18','12:55:55',1);
	insert into veiculo(placa, cor, modelo, marca, ativado) values('QXS-2628','Azul','Mobi','Fiat', 1);
    insert into servicos(valorHora, fracao, ativado) values(20, 10, 2);
        
    insert into clienteComVeiculos(idCliente, idVeiculo) values(2,3);
    insert into OrdemServicoComClienteServico(idCliente,idServicos,idOrdemServico,idVeiculo) values(2,2,3,3);
    
	insert into veiculo(placa, cor, modelo, marca, ativado) values('QDX-2623','Branco','Freemont','Fiat', 1);
    
select * from ordemServico;
select * from veiculo;
select * from servicos;
select * from cliente;
select * from clienteComVeiculos;
select * from OrdemServicoComClienteServico;


delete from clienteComVeiculos where idVeiculo = 4;
