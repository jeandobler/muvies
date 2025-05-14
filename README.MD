# Muuuuvies - Planeje sua lista de filmes com facilidade!

## Planejamento

A aplicação **Muuuuvies** foi desenvolvida utilizando as seguintes tecnologias e arquiteturas:

- **MVVM**: Arquitetura para separar a lógica de negócio da interface do usuário.
- **Koin**: Framework de injeção de dependências.
- **Jetpack Compose**: UI declarativa para construir interfaces.
- **Room**: Biblioteca para persistência de dados em SQLite.
- **Retrofit**: Cliente HTTP para consumir APIs RESTful.
- **Robolectric**: Framework de testes unitários para Android.
- **Crashlytics**: Monitoramento de falhas e erros em tempo real.

## Estrutura do Projeto

A aplicação foi organizada para ter **duas telas principais**:

1. **Tela de consumo de API**: Onde os dados são obtidos através de uma requisição para a API.
2. **Tela de consumo de banco de dados (Room)**: Onde os dados são persistidos localmente e consumidos diretamente do banco de dados.

A estrutura foi pensada para **facilitar o controle dos dados** sem comprometer a organização e escalabilidade do projeto.

## Próximos Passos

Para melhorar a aplicação e a qualidade do código, os seguintes passos serão implementados:

- **Adicionar RoboRazzi**: Para testes de interface de usuário em ambientes Android.
- **Aplicar Jacoco**: Para medir a cobertura de testes e garantir que o código está adequadamente testado.
- **Adicionar e corrigir testes de integração**: Testar a interação entre as diferentes partes da aplicação.
- **Terminar de configurar o Firebase**: Finalizar a configuração para utilizar autenticação, banco de dados em tempo real, e outras funcionalidades do Firebase.
- **Corrigir o inputbox de busca**: Melhorar a interação do campo de busca com o usuário.
- **Criar animação para adição e remoção de filmes no Room**: Melhorar a experiência do usuário com animações.
- **Melhorar Design System (DS)**: Refinar os componentes e layouts para garantir uma UI mais coesa e moderna.
- **Adicionar build-logic**: Centralizar a lógica do build para facilitar a manutenção e escalabilidade do processo de construção da aplicação.
