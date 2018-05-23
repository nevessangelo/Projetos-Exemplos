-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 20-Maio-2018 às 20:54
-- Versão do servidor: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grupo_ifgnu`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_acesso`
--

CREATE TABLE `tbl_acesso` (
  `cod_acesso` int(4) NOT NULL,
  `acesso_nivel` varchar(60) NOT NULL,
  `cod_login` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_acesso`
--

INSERT INTO `tbl_acesso` (`cod_acesso`, `acesso_nivel`, `cod_login`) VALUES
(1, 'Administrador', 1),
(2, 'Gerente', 3),
(3, 'Gerente', 4),
(4, 'Gerente', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_aluno`
--

CREATE TABLE `tbl_aluno` (
  `cod_aluno` int(4) NOT NULL,
  `nome_aluno` varchar(100) NOT NULL,
  `email_aluno` varchar(100) NOT NULL,
  `data_ingresso_aluno` date NOT NULL,
  `cod_orientador` int(4) NOT NULL,
  `regime_curso` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_aluno`
--

INSERT INTO `tbl_aluno` (`cod_aluno`, `nome_aluno`, `email_aluno`, `data_ingresso_aluno`, `cod_orientador`, `regime_curso`) VALUES
(2, 'Maria ', 'maria@email.br', '2006-03-01', 2, NULL),
(3, 'João', 'joao@email.br', '2005-03-01', 3, NULL),
(4, 'Mário ', 'mario@email.br', '2007-03-01', 3, NULL),
(5, 'Soraia', 'soraia@email.br', '2006-03-01', 2, 'parcial'),
(6, 'Rafael', 'rafael@email.br', '2007-06-01', 4, 'integral'),
(7, 'Marta', 'marta@email.br', '2007-06-01', 4, 'integral'),
(8, 'Daniel', 'daniel@email.br', '2006-03-01', 4, 'integral'),
(9, 'Michael', 'michael@email.br', '2005-03-01', 2, 'integral'),
(10, 'Bia', 'bia@email.br', '2004-06-01', 2, 'integral');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_alunos_projeto`
--

CREATE TABLE `tbl_alunos_projeto` (
  `cod_alunos_projeto` int(4) NOT NULL,
  `cod_projeto` int(4) NOT NULL,
  `cod_aluno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_alunos_projeto`
--

INSERT INTO `tbl_alunos_projeto` (`cod_alunos_projeto`, `cod_projeto`, `cod_aluno`) VALUES
(1, 2, 3),
(2, 2, 4),
(3, 2, 6),
(4, 2, 7),
(5, 2, 8),
(6, 2, 9),
(7, 2, 10),
(8, 3, 2),
(9, 3, 3),
(10, 3, 5),
(11, 3, 8),
(12, 3, 9),
(13, 4, 2),
(14, 4, 4),
(15, 4, 6),
(16, 4, 7),
(17, 4, 8),
(18, 4, 10),
(19, 5, 2),
(20, 5, 4),
(21, 5, 6),
(22, 5, 7),
(23, 5, 8),
(24, 5, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_aluno_publicacao`
--

CREATE TABLE `tbl_aluno_publicacao` (
  `cod_aluno_publicacoes` int(4) NOT NULL,
  `cod_publicacao` int(4) NOT NULL,
  `cod_aluno` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_aluno_publicacao`
--

INSERT INTO `tbl_aluno_publicacao` (`cod_aluno_publicacoes`, `cod_publicacao`, `cod_aluno`) VALUES
(3, 5, 5),
(4, 5, 9),
(5, 6, 7),
(6, 6, 8),
(7, 7, 2),
(8, 7, 10),
(9, 8, 5),
(10, 12, 3),
(11, 12, 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_login`
--

CREATE TABLE `tbl_login` (
  `id_login` int(4) NOT NULL,
  `nome_login` varchar(200) NOT NULL,
  `senha_login` varchar(200) NOT NULL,
  `nivel_acesso` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_login`
--

INSERT INTO `tbl_login` (`id_login`, `nome_login`, `senha_login`, `nivel_acesso`) VALUES
(1, 'admin', 'admin', 'Administrador'),
(3, 'carlos', 'carlos', 'Gerente'),
(4, 'arnaldo', 'arnaldo', 'Gerente'),
(5, 'paulo', 'paulo', 'Gerente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_orientacao`
--

CREATE TABLE `tbl_orientacao` (
  `cod_orientacao` int(4) NOT NULL,
  `titulo_orientacao` varchar(60) NOT NULL,
  `cod_professor` int(4) NOT NULL,
  `cod_aluno` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_orientacao`
--

INSERT INTO `tbl_orientacao` (`cod_orientacao`, `titulo_orientacao`, `cod_professor`, `cod_aluno`) VALUES
(4, 'Usabilidade no Portal do Banco do Brasil', 2, 2),
(5, 'Framework para o Cálculo de Reputação de Agentes', 2, 5),
(6, 'Catálogos de Objetos baseado em Ontologias', 4, 6),
(7, 'Framework para Smart Cards', 4, 8),
(8, 'Linguagem de Modelagem para Sistemas baseados em Agentes', 2, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_professor`
--

CREATE TABLE `tbl_professor` (
  `cod_professor` int(4) NOT NULL,
  `nome_professor` varchar(100) NOT NULL,
  `email_professor` varchar(100) NOT NULL,
  `cod_login` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_professor`
--

INSERT INTO `tbl_professor` (`cod_professor`, `nome_professor`, `email_professor`, `cod_login`) VALUES
(2, 'Prof. Carlos', 'carlos@email.br', 3),
(3, 'Prof. Arnaldo', 'arnaldo@email.br', 4),
(4, 'Prof. Paulo', 'paulo@email.br', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_professores_projeto`
--

CREATE TABLE `tbl_professores_projeto` (
  `id_professores_projeto` int(4) NOT NULL,
  `cod_projeto` int(4) NOT NULL,
  `cod_professor` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_professores_projeto`
--

INSERT INTO `tbl_professores_projeto` (`id_professores_projeto`, `cod_projeto`, `cod_professor`) VALUES
(1, 2, 2),
(2, 2, 3),
(3, 3, 2),
(4, 3, 3),
(5, 4, 3),
(6, 4, 4),
(7, 5, 3),
(8, 5, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_professor_publicacao`
--

CREATE TABLE `tbl_professor_publicacao` (
  `cod_professor_publicacao` int(4) NOT NULL,
  `cod_professor` int(4) NOT NULL,
  `cod_publicacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_professor_publicacao`
--

INSERT INTO `tbl_professor_publicacao` (`cod_professor_publicacao`, `cod_professor`, `cod_publicacao`) VALUES
(3, 2, 5),
(4, 4, 6),
(5, 2, 7),
(6, 2, 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_projeto`
--

CREATE TABLE `tbl_projeto` (
  `cod_projeto` int(4) NOT NULL,
  `projeto_titulo` varchar(200) NOT NULL,
  `data_inicio_projeto` date NOT NULL,
  `data_termino_projeto` date NOT NULL,
  `agencia_projeto` varchar(200) NOT NULL,
  `valor_financiado_projeto` double NOT NULL,
  `objetivo_projeto` varchar(200) NOT NULL,
  `descricao_projeto` varchar(200) NOT NULL,
  `status_projeto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_projeto`
--

INSERT INTO `tbl_projeto` (`cod_projeto`, `projeto_titulo`, `data_inicio_projeto`, `data_termino_projeto`, `agencia_projeto`, `valor_financiado_projeto`, `objetivo_projeto`, `descricao_projeto`, `status_projeto`) VALUES
(2, 'Engenharia de Software para Sistemas Multi-Agentes (ESMA)', '2003-02-02', '2010-02-02', 'FPCL', 300, 'O objetivo geral deste projeto Ã© desenvolver os fundamentos e as tecnologias da ESSMA.', 'Pesquisar, aplicar e avaliar tÃ©cnicas de desenvolvimento de software para sistemas multi-agentes..', 'andamento'),
(3, 'Engenharia de Software Orientada a Aspectos (ESOA)', '2005-02-02', '2011-12-02', 'FPCL', 190, 'O objetivo geral deste projeto Ã© desenvolver os fundamentos e as tecnologias da ESOA.', 'Pesquisar, aplicar e avaliar tÃ©cnicas de desenvolvimento de software orientado Ã  aspectos..', 'andamento'),
(4, 'Qualidade de Software', '2006-05-02', '2009-10-02', 'FPCL', 100, 'O objetivo deste projeto Ã© desenvolver os fundamentos e as tecnologias para desenvolvimento de software com qualidade.', 'Pesquisar, aplicar e avaliar tÃ©cnicas para qualidade em desenvolvimento de software.', 'elaboração'),
(5, 'Model-driven Software Product Lines Development', '2007-05-02', '2010-05-02', 'FPCL', 500, 'O objetivo deste projeto Ã© elaborar tÃ©cnicas de engenharia de software dirigadas a modelos para o desenvolvimento de linhas de produtos de software', 'Pesquisar, aplicar e avaliar tÃ©cnicas para o desenvolvimento de linhas de produtos de software.', 'elaboração'),
(6, 'Multi-agent Systems', '2008-07-15', '2010-10-02', 'FPCL', 150, 'O objetivo deste projeto Ã© desenvolver sistemas multi-agentes autoorganizÃ¡veis.', 'Pesquisar, aplicar e avaliar tÃ©cnicas para o desenvolvimento de sistemas multi-agentes auto-organizÃ¡veis.', 'elaboração');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_publicacao`
--

CREATE TABLE `tbl_publicacao` (
  `cod_publicacao` int(4) NOT NULL,
  `titulo_publicacao` varchar(200) NOT NULL,
  `conferencia_publicacao` varchar(200) NOT NULL,
  `ano_pulicacao` int(4) NOT NULL,
  `cod_projeto` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_publicacao`
--

INSERT INTO `tbl_publicacao` (`cod_publicacao`, `titulo_publicacao`, `conferencia_publicacao`, `ano_pulicacao`, `cod_projeto`) VALUES
(5, 'Abordagem Quantitativa para Desenvolvimento de Software Orientado a Aspectos', '3', 2006, 3),
(6, 'Integrating MAS in a component-based groupware environment', '2', 2006, 2),
(7, 'Reputation Model Based on Testimonies', '2', 2006, 2),
(8, 'Aspect-oriented Patterns', '3', 2006, 3),
(12, 'Classifying and Describing Agent Contracts and Norms', '2', 2005, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_acesso`
--
ALTER TABLE `tbl_acesso`
  ADD PRIMARY KEY (`cod_acesso`),
  ADD KEY `fk_acesso` (`cod_login`);

--
-- Indexes for table `tbl_aluno`
--
ALTER TABLE `tbl_aluno`
  ADD PRIMARY KEY (`cod_aluno`),
  ADD KEY `fk_orientador` (`cod_orientador`);

--
-- Indexes for table `tbl_alunos_projeto`
--
ALTER TABLE `tbl_alunos_projeto`
  ADD PRIMARY KEY (`cod_alunos_projeto`),
  ADD KEY `fk_alunos_projeto` (`cod_aluno`),
  ADD KEY `fk_al_projeto` (`cod_projeto`);

--
-- Indexes for table `tbl_aluno_publicacao`
--
ALTER TABLE `tbl_aluno_publicacao`
  ADD PRIMARY KEY (`cod_aluno_publicacoes`),
  ADD KEY `fk_aluno_publicacoes` (`cod_aluno`),
  ADD KEY `fk_publicacao1` (`cod_publicacao`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`id_login`);

--
-- Indexes for table `tbl_orientacao`
--
ALTER TABLE `tbl_orientacao`
  ADD PRIMARY KEY (`cod_orientacao`),
  ADD KEY `fk_orientacao_professor` (`cod_professor`),
  ADD KEY `fk_orientacao_aluno` (`cod_aluno`);

--
-- Indexes for table `tbl_professor`
--
ALTER TABLE `tbl_professor`
  ADD PRIMARY KEY (`cod_professor`),
  ADD KEY `fk_login_professor` (`cod_login`);

--
-- Indexes for table `tbl_professores_projeto`
--
ALTER TABLE `tbl_professores_projeto`
  ADD PRIMARY KEY (`id_professores_projeto`),
  ADD KEY `fk_nome_professores` (`cod_professor`),
  ADD KEY `fk_codigo_professores` (`cod_projeto`);

--
-- Indexes for table `tbl_professor_publicacao`
--
ALTER TABLE `tbl_professor_publicacao`
  ADD PRIMARY KEY (`cod_professor_publicacao`),
  ADD KEY `fk_publicacao2` (`cod_publicacao`),
  ADD KEY `fk_professor_publicacao` (`cod_professor`);

--
-- Indexes for table `tbl_projeto`
--
ALTER TABLE `tbl_projeto`
  ADD PRIMARY KEY (`cod_projeto`);

--
-- Indexes for table `tbl_publicacao`
--
ALTER TABLE `tbl_publicacao`
  ADD PRIMARY KEY (`cod_publicacao`),
  ADD KEY `fk_projeto` (`cod_projeto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_acesso`
--
ALTER TABLE `tbl_acesso`
  MODIFY `cod_acesso` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_aluno`
--
ALTER TABLE `tbl_aluno`
  MODIFY `cod_aluno` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_alunos_projeto`
--
ALTER TABLE `tbl_alunos_projeto`
  MODIFY `cod_alunos_projeto` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `tbl_aluno_publicacao`
--
ALTER TABLE `tbl_aluno_publicacao`
  MODIFY `cod_aluno_publicacoes` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `tbl_login`
--
ALTER TABLE `tbl_login`
  MODIFY `id_login` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_orientacao`
--
ALTER TABLE `tbl_orientacao`
  MODIFY `cod_orientacao` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_professor`
--
ALTER TABLE `tbl_professor`
  MODIFY `cod_professor` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_professores_projeto`
--
ALTER TABLE `tbl_professores_projeto`
  MODIFY `id_professores_projeto` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_professor_publicacao`
--
ALTER TABLE `tbl_professor_publicacao`
  MODIFY `cod_professor_publicacao` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_projeto`
--
ALTER TABLE `tbl_projeto`
  MODIFY `cod_projeto` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_publicacao`
--
ALTER TABLE `tbl_publicacao`
  MODIFY `cod_publicacao` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tbl_acesso`
--
ALTER TABLE `tbl_acesso`
  ADD CONSTRAINT `fk_acesso` FOREIGN KEY (`cod_login`) REFERENCES `tbl_login` (`id_login`);

--
-- Limitadores para a tabela `tbl_aluno`
--
ALTER TABLE `tbl_aluno`
  ADD CONSTRAINT `fk_orientador` FOREIGN KEY (`cod_orientador`) REFERENCES `tbl_professor` (`cod_professor`);

--
-- Limitadores para a tabela `tbl_alunos_projeto`
--
ALTER TABLE `tbl_alunos_projeto`
  ADD CONSTRAINT `fk_al_projeto` FOREIGN KEY (`cod_projeto`) REFERENCES `tbl_projeto` (`cod_projeto`),
  ADD CONSTRAINT `fk_alunos_projeto` FOREIGN KEY (`cod_aluno`) REFERENCES `tbl_aluno` (`cod_aluno`);

--
-- Limitadores para a tabela `tbl_aluno_publicacao`
--
ALTER TABLE `tbl_aluno_publicacao`
  ADD CONSTRAINT `fk_aluno_publicacoes` FOREIGN KEY (`cod_aluno`) REFERENCES `tbl_aluno` (`cod_aluno`),
  ADD CONSTRAINT `fk_publicacao1` FOREIGN KEY (`cod_publicacao`) REFERENCES `tbl_publicacao` (`cod_publicacao`);

--
-- Limitadores para a tabela `tbl_orientacao`
--
ALTER TABLE `tbl_orientacao`
  ADD CONSTRAINT `fk_orientacao_aluno` FOREIGN KEY (`cod_aluno`) REFERENCES `tbl_aluno` (`cod_aluno`),
  ADD CONSTRAINT `fk_orientacao_professor` FOREIGN KEY (`cod_professor`) REFERENCES `tbl_professor` (`cod_professor`);

--
-- Limitadores para a tabela `tbl_professor`
--
ALTER TABLE `tbl_professor`
  ADD CONSTRAINT `fk_login_professor` FOREIGN KEY (`cod_login`) REFERENCES `tbl_login` (`id_login`);

--
-- Limitadores para a tabela `tbl_professores_projeto`
--
ALTER TABLE `tbl_professores_projeto`
  ADD CONSTRAINT `fk_codigo_professores` FOREIGN KEY (`cod_projeto`) REFERENCES `tbl_projeto` (`cod_projeto`),
  ADD CONSTRAINT `fk_nome_professores` FOREIGN KEY (`cod_professor`) REFERENCES `tbl_professor` (`cod_professor`);

--
-- Limitadores para a tabela `tbl_professor_publicacao`
--
ALTER TABLE `tbl_professor_publicacao`
  ADD CONSTRAINT `fk_professor_publicacao` FOREIGN KEY (`cod_professor`) REFERENCES `tbl_professor` (`cod_professor`),
  ADD CONSTRAINT `fk_publicacao2` FOREIGN KEY (`cod_publicacao`) REFERENCES `tbl_publicacao` (`cod_publicacao`);

--
-- Limitadores para a tabela `tbl_publicacao`
--
ALTER TABLE `tbl_publicacao`
  ADD CONSTRAINT `fk_projeto` FOREIGN KEY (`cod_projeto`) REFERENCES `tbl_projeto` (`cod_projeto`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
