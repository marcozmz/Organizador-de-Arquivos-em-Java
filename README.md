# 📂 Organizador de Arquivos em Java

Este é um projeto de automação desenvolvido em Java que organiza pastas bagunçadas, movendo arquivos para subpastas específicas de acordo com suas extensões e renomeando-os seguindo um padrão numérico.

## 🚀 Funcionalidades
- **Seleção Visual:** Abre uma janela (`JFileChooser`) para selecionar a pasta desejada.
- **Filtro Inteligente:** Identifica Imagens (JPG, PNG, WebP) e Documentos (PDF).
- **Auto-Organização:** Cria as subpastas automaticamente caso elas não existam.
- **Renomeação Padronizada:** Renomeia arquivos para formatos como `foto_01.jpg` ou `arquivo_01.pdf`.
- **Segurança:** Ignora pastas internas para evitar erros de movimentação.

## 🛠️ Tecnologias Utilizadas
- **Java 17+**
- **Java NIO (Path, Files, DirectoryStream)**
- **Swing (JFileChooser)** para interface básica.

## 📖 Como aprendi
Neste projeto, foquei em aprender a manipulação moderna de arquivos no Java (NIO), o uso de `Streams` para lidar com grandes volumes de dados de forma eficiente e a lógica de tratamento de Strings para renomeação.
