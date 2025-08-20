✈️ Gerenciador de Roteiros de Viagem
Este é um projeto full-stack para gerenciar e planejar roteiros de viagem personalizados. O aplicativo permite que o usuário crie, edite e visualize roteiros, com funcionalidades de back-end em Java e uma interface de usuário interativa em React.

🚀 Tecnologias
Back-end
Linguagem: Java

Framework: Spring Boot

Banco de Dados: PostgreSQL

Acesso a Dados: Spring Data JPA

Ferramenta de Build: Maven

Front-end
Biblioteca: React

Build Tool: Vite

Gerenciador de Pacotes: npm

Requisições HTTP: Axios

✨ Funcionalidades
Back-end (API)
Gerenciamento de usuários.

Operações CRUD (Criar, Ler, Atualizar, Deletar) para roteiros de viagem.

Operações CRUD para Pontos de Interesse (POIs) associados a roteiros.

Front-end (UI)
Tela inicial para visualizar a lista de roteiros existentes.

Interface para criar e editar roteiros.

Formulário para adicionar novos roteiros ao banco de dados.

Mensagens de feedback para carregamento e erros.

🛠️ Como Configurar e Rodar
Pré-requisitos
Java Development Kit (JDK) 17 ou superior.

Node.js (versão LTS recomendada).

PostgreSQL instalado e rodando.

1. Configuração do Back-end
   Clone este repositório.

Navegue até a pasta do back-end (gerenciador-roteiros-backend).

Configure o banco de dados no arquivo src/main/resources/application.properties com suas credenciais do PostgreSQL.

Execute a aplicação usando o Maven:

./mvnw spring-boot:run

2. Configuração do Front-end
   Navegue até a pasta do front-end (gerenciador-roteiros-front).

Instale as dependências:

npm install

Inicie o servidor de desenvolvimento:

npm run dev

A aplicação front-end estará disponível em http://localhost:5173.

🗺️ Próximas Etapas e Desafios
Integração com API Externa: Conectar o front-end com a Google Maps Platform para visualizar roteiros e POIs no mapa.

Autenticação de Usuário: Implementar um sistema de login e registro mais robusto.

Interface Aprimorada: Adicionar estilos com um framework CSS (como Tailwind CSS ou Bootstrap) para melhorar o design.

Este projeto foi criado com o auxílio de uma IA