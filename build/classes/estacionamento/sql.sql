drop database estacionamento;
create database estacionamento;
use estacionamento;

    create table cliente(
    idCliente int not null primary key auto_increment,
	condutor varchar(45),
	tipoCliente boolean,
	valorPagoCliente double,
    ativado int
    );
    
    create table ordemServico(
    idOrdemServico int not null primary key auto_increment,
    dataEntrada date,
    horaEntrada time,
    dataSaida date,
    horaSaida time,
    valorServico double,
    ativado int
    );
    
    create table veiculo(
     idVeiculo int not null primary key auto_increment,
     placa varchar(45),
     cor varchar(45),
     modelo varchar(45),
     marca varchar(45),
    ativado int
	);
    
    create table servicos(
    idServicos int not null primary key auto_increment,
    valorHora double,
    fracao int,
    ativado int
    );
    
    create table clienteComVeiculos(
		idCliente INT NOT NULL,
		idVeiculo INT NOT NULL,
		PRIMARY KEY(IDCLIENTE, IDVEICULO),
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
		FOREIGN KEY (idOrdemServico) REFERENCES ordemServico (idOrdemServico)
	);
    
    create table OrdemServicoComServicos(
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
	insert into OrdemServicoComClienteServico(idCliente,idServicos,idOrdemServico) values(1,1,1);
        
    insert into ordemServico(valorServico,dataEntrada,horaEntrada,ativado) values (20,'2019-3-18','12:55:55',1);
	insert into veiculo(placa, cor, modelo, marca, ativado) values('QXH-2326','preto','GOL','VK', 1);
    insert into servicos(valorHora, fracao, ativado) values(20, 10, 2);
	insert into cliente(condutor, tipoCliente, valorPagoCliente,ativado) values('Maria',true, 20,1);
        
    insert into clienteComVeiculos(idCliente, idVeiculo) values(2,2);
    insert into OrdemServicoComClienteServico(idCliente,idServicos,idOrdemServico) values(2,2,2);
    
select * from ordemServico;
select * from veiculo;
select * from servicos;
select * from cliente;
select * from clienteComVeiculos;
select * from OrdemServicoComClienteServico;

select * from veiculo where idVeiculo = 1;

select * from  veiculo inner join cliente on veiculo.idveiculo = cliente.veiculo;

UPDATE ordemServico SET valorServico = 20.0,dataEntrada = '2019-03-18',horaEntrada = '12:55:55',dataSaida= '2019-03-18', horaSaida= '00:29:52',cliente = 1,  servico = 2, ativado =0  WHERE idOrdemServico = 2;

select * from veiculo;

select * from veiculo where placa like 'Qd%';

select idcliente, condutor, tipoCliente, valorPagoCliente, ativado from cliente where condutor like '%';

select veiculo.idVeiculo, veiculo.placa, veiculo.cor,veiculo.modelo, veiculo.marca, veiculo.ativado 
from  clienteComVeiculos
 inner join cliente on
 clienteComVeiculos.idCliente = cliente.idCliente 
 inner join veiculo on
 clienteComVeiculos.idVeiculo = veiculo.idVeiculo 
 where cliente.idCliente = 2;

select ordemServico.idOrdemServico, ordemServico.dataEntrada,ordemServico.horaEntrada,ordemServico.dataSaida,ordemServico.horaSaida, ordemServico.valorServico,ordemServico.ativado, cliente.idCliente, cliente.condutor,cliente.tipoCliente,cliente.valorPagoCliente, cliente.ativado, servicos.idServicos, servicos.valorHora,servicos.fracao,servicos.ativado
 from OrdemServicoComClienteServico inner join cliente on cliente.idCliente = OrdemServicoComClienteServico.idCliente inner join servicos on servicos.idServicos = OrdemServicoComClienteServico.idServicos inner join ordemServico on ordemServico.idOrdemServico = OrdemServicoComClienteServico.idOrdemServico;

select * 
from OrdemServicoComClienteServico 
inner join cliente on
cliente.idCliente = OrdemServicoComClienteServico.idCliente
inner join servicos on
servicos.idServicos = OrdemServicoComClienteServico.idServicos
inner join ordemServico on
ordemServico.idOrdemServico = OrdemServicoComClienteServico.idOrdemServico;