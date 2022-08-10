CREATE TABLE question
(
    id             UUID    NOT NULL,
    question       VARCHAR(255),
    optiona        VARCHAR(255),
    optionb        VARCHAR(255),
    optionc        VARCHAR(255),
    optiond        VARCHAR(255),
    correct_answer INTEGER NOT NULL,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

INSERT INTO question(id, question, optiona, optionb, optionc, optiond, correct_answer) VALUES
('d3e196c9-0921-42f1-a149-af109abd92af', 'Qual bicho transmite Doença de Chagas?', 'Abelha', 'Barbeiro', 'Macaco', 'João', '1'),
('614ff02c-c3ae-4726-97e4-6d8c2f0f19fd', 'Um número múltiplo de cinco é?', 'Um número que é divisível por 3', 'Um número que é divisível por 5', 'Um número que multiplicado por 5 é par', 'Um número que somado com 5 é impar', '1'),
('9cce3b51-ccfc-4dac-8410-96d94d4153b4', 'Qual o nome do principal do personagem de Dragon Ball?', 'Goku', 'Freeza', 'Mabel', 'Kin Jon-un', '0'),
('dd249793-2730-47ca-a164-bdb83b8bf97a', 'De quanto em quanto tempo acontece uma Copa do Mundo?', 'De dois em dois anos', 'De oito em oitro anos', 'Ocorre todos os anos', 'De quatro em quatro anos', '3'),
('16b14902-157a-4ddb-a84d-d7859f00b977', 'Qual a cor que simboliza a esperança?', 'Branco', 'Verde', 'Azul', 'Vermelho', '0'),
('7fa0a052-4efa-49fd-b077-2e3947b42711', 'Quais os dois primeiros nomes da apresentadora Xuxa?', 'Maria de Lourdes', 'Maria do Carmo', 'Maria da Graça', 'Maria Isabel', '3'),
('285ea930-c79e-4a75-b0f6-3352c5ee57fa', 'Qual o presidente brasileiro responsável pela constução de brasília?', 'Jãnio Quadros', 'Juscelino Kubitschek', 'Getúlio Vargas', 'Eurico Gaspar Dutra', '1'),
('0a829b81-71ed-4818-a5d6-aeafd022e05f', 'Em qual estado brasileiro ocorreu a guerra de canudos?', 'Sergipe', 'Bahia', 'São Paulo', 'Rio de Janeiro', '1'),
('56d06995-99c0-427d-91d4-f99428e021f9', 'Como se chama o ratinho criado por Walt Disney?', 'Mickey Mouse', 'Pateta', 'Jerry', 'Pink', '0');