# Configuração do Ambiente de Desenvolvimento

> **Escopo:** instruções para configurar o projeto Android `Componentes`, que contém a biblioteca `:componentes` e o aplicativo de demonstração `:app`.
>
> **Evidência:** versões e requisitos específicos abaixo foram extraídos dos arquivos Gradle e do wrapper deste repositório. A lista de sistemas operacionais oficialmente suportados e as versões mínimas de Android Studio ainda não estão documentadas.

## 1. Pré-requisitos

| Ferramenta | Versão/configuração | Finalidade |
|---|---|---|
| Git | Instalação disponível no ambiente | Clonar o repositório e obter atualizações |
| Java Development Kit (JDK) | 17 para executar o Gradle configurado neste projeto | JVM do Gradle Wrapper |
| Android SDK | Android SDK Platform 36 | Compilar os dois módulos, que definem `compileSdk 36` |
| Android Studio | Versão compatível com Android Gradle Plugin 9.4.1 | Importar o projeto, configurar o SDK e executar o app de demonstração |
| Gradle | Usar `gradlew`/`gradlew.bat` incluído no repositório (9.6.0) | Executar as tarefas de build sem instalação global do Gradle |

O Android SDK precisa ter acesso aos repositórios Google Maven e Maven Central usados para resolver plugins e dependências. Para executar o app de demonstração, configure também um emulador Android ou conecte um dispositivo com depuração USB habilitada.

O projeto declara `minSdk 23` nos dois módulos e `targetSdk 36` no aplicativo de demonstração. Esses valores são configurações do build, não uma declaração de política oficial de compatibilidade de produto.

## 2. Clonar e importar

```powershell
git clone https://github.com/Concyline/Componentes.git
Set-Location .\Componentes
```

No Android Studio, abra a pasta raiz `Componentes` (a que contém `settings.gradle`) e aguarde a sincronização Gradle. Se solicitado, selecione o JDK 17 como Gradle JDK e instale Android SDK Platform 36 pelo SDK Manager.

O Android Studio normalmente configura o caminho do SDK local no arquivo `local.properties`. Esse arquivo é específico da máquina, está no `.gitignore` e não deve ser commitado.

## 3. Estrutura dos módulos

| Módulo | Descrição |
|---|---|
| `:componentes` | Biblioteca Android de componentes reutilizáveis |
| `:app` | Aplicativo de demonstração que depende de `:componentes` |

O projeto usa Java. A compatibilidade de compilação declarada é Java 17 para a biblioteca e Java 11 para o aplicativo; isso não altera o requisito de JDK 17 para executar a versão atual do Gradle Wrapper.

As versões de plugins e bibliotecas são centralizadas em `gradle/libs.versions.toml`. Os scripts Gradle configuram Google Maven e Maven Central como repositórios.

## 4. Build e validação

Execute os comandos a partir da pasta raiz do repositório.

No Windows PowerShell:

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :componentes:assembleRelease
.\gradlew.bat :componentes:testDebugUnitTest
```

Em macOS ou Linux:

```bash
./gradlew :app:assembleDebug
./gradlew :componentes:assembleRelease
./gradlew :componentes:testDebugUnitTest
```

Os artefatos de build ficam nos diretórios `app/build/outputs/` e `componentes/build/outputs/`. O repositório declara dependências e runners de teste JUnit/AndroidX/Espresso, mas não foram encontrados arquivos de teste nos módulos na última verificação. A tarefa de teste pode, portanto, não executar casos de teste até que eles sejam adicionados.

Para validar a demonstração em um dispositivo ou emulador conectado:

```powershell
.\gradlew.bat :app:installDebug
```

Ou execute a configuração `app` pelo Android Studio.

## 5. Configuração local e solução de problemas

- **SDK não encontrado:** abra o projeto pelo Android Studio, instale Android SDK Platform 36 no SDK Manager e confira o caminho local configurado em `local.properties`. Não compartilhe nem versione esse arquivo.
- **JVM incompatível:** configure o JDK 17 para o Gradle no Android Studio ou no ambiente de execução. O Wrapper usa Gradle 9.6.0.
- **Dependências não resolvidas:** confirme acesso à internet e aos repositórios Google Maven e Maven Central; as dependências são baixadas pelo Gradle.
- **App não instalado em dispositivo:** confira se há um emulador iniciado ou um dispositivo autorizado com depuração USB habilitada.

Não inclua chaves, senhas, tokens ou outros segredos em arquivos versionados. Os arquivos `local.properties`, `*.jks`, `*.keystore` e `google-services.json` estão listados no `.gitignore`; não os adicione ao controle de versão.

## 6. Itens ainda não confirmados

- Sistemas operacionais oficialmente suportados pela equipe.
- Versão mínima de Android Studio homologada.
- Se builds de release exigem configurações locais adicionais.
- Cobertura e procedimento oficial de testes automatizados.
- Requisitos de CI, publicação e assinatura do aplicativo.

Esses itens devem ser preenchidos após confirmação ou validação no ambiente de desenvolvimento oficial; não devem ser presumidos a partir dos exemplos deste guia.
