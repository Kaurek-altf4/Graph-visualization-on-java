# Загрузчик конфигурации на Java

Первый прототип приложения: читает параметры из CSV-файла и выводит полученную конфигурацию в терминал.

## Структура

```text
first prototype/
├── src/
│   ├── Main.java
│   ├── Config.java
│   ├── ConfigException.java
│   └── configLoader.java
├── config/
│   └── config.csv
├── run.sh
├── .gitignore
├── .gitattributes
└── README.md
```

При запуске создаётся `build/classes/` со скомпилированными `.class`-файлами. Папка сборки исключена из Git; в репозитории хранятся исходники.

## Требования

JDK 11 или новее (должны быть доступны `java` и `javac`) и Bash. Maven, Gradle и сторонние библиотеки не нужны. Код можно редактировать в Neovim или другом редакторе.

## Запуск

Из корня проекта:

```bash
bash run.sh
```

Скрипт сам переходит в папку проекта, компилирует Java-файлы в `build/classes/` и запускает `Main`. Его можно вызвать и из другой папки, указав полный путь к `run.sh` в кавычках.

Сборка и запуск вручную из корня проекта:

```bash
mkdir -p build/classes
javac -encoding UTF-8 --release 11 -d build/classes src/*.java
java -cp build/classes Main
```

## Конфигурация

Программа читает `config/config.csv`. Каждая запись имеет формат `ключ,значение`:

```text
packageName,com.example.app
repositoryUrl,https://github.com/example
mode,url
maxDepth,5
```

Обязательные поля: `packageName`, `repositoryUrl`, `mode`, `maxDepth`. Пустые строки и строки, начинающиеся после пробелов с `#`, пропускаются. Пробелы вокруг ключей и значений удаляются; разделение происходит по первой запятой.

## Реализовано

- Чтение конфигурации из файла.
- Проверка наличия запятой, непустых ключей и значений, повторяющихся ключей и обязательных полей.
- Преобразование `maxDepth` в целое число.
- Вывод загруженных параметров и сообщений `ConfigException`.

`repositoryUrl` здесь только читается как строка: приложение не подключается к репозиторию и не скачивает пакеты. Допустимость URL и `mode`, а также диапазон `maxDepth` пока не проверяются. Нечисловой `maxDepth` вызывает стандартную `NumberFormatException`, которая пока не обрабатывается как `ConfigException`.

4 Этап Работа npm (express)
npm http fetch GET 200 https://registry.npmjs.org/hasown/-/hasown-2.0.4.tgz 52ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/math-intrinsics/-/math-intrinsics-1.1.0.tgz 54ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/dunder-proto/-/dunder-proto-1.0.1.tgz 53ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/media-typer/-/media-typer-1.1.1.tgz 55ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/call-bound/-/call-bound-1.0.4.tgz 94ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/get-intrinsic/-/get-intrinsic-1.3.0.tgz 104ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/is-promise/-/is-promise-4.0.0.tgz 108ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/es-errors/-/es-errors-1.3.0.tgz 109ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/side-channel-map/-/side-channel-map-1.0.1.tgz 127ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/unpipe/-/unpipe-1.0.0.tgz 127ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/es-define-property/-/es-define-property-1.0.1.tgz 140ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/side-channel/-/side-channel-1.1.1.tgz 142ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/forwarded/-/forwarded-0.2.0.tgz 146ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/gopd/-/gopd-1.2.0.tgz 149ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/path-to-regexp/-/path-to-regexp-8.4.2.tgz 150ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/es-object-atoms/-/es-object-atoms-1.1.2.tgz 153ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/wrappy/-/wrappy-1.0.2.tgz 159ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/function-bind/-/function-bind-1.1.2.tgz 162ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/mime-db/-/mime-db-1.54.0.tgz 172ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/side-channel-list/-/side-channel-list-1.0.1.tgz 175ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/side-channel-weakmap/-/side-channel-weakmap-1.0.2.tgz 175ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/ipaddr.js/-/ipaddr.js-1.9.1.tgz 175ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/call-bind-apply-helpers/-/call-bind-apply-helpers-1.0.2.tgz 177ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/get-proto/-/get-proto-1.0.1.tgz 181ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/ee-first/-/ee-first-1.1.1.tgz 181ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/setprototypeof/-/setprototypeof-1.2.0.tgz 182ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/inherits/-/inherits-2.0.4.tgz 182ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/ms/-/ms-2.1.3.tgz 184ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/safer-buffer/-/safer-buffer-2.1.2.tgz 186ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/has-symbols/-/has-symbols-1.1.0.tgz 189ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/raw-body/-/raw-body-3.0.2.tgz 188ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/object-inspect/-/object-inspect-1.13.4.tgz 198ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/vary/-/vary-1.1.2.tgz 196ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/statuses/-/statuses-2.0.2.tgz 198ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/type-is/-/type-is-2.1.0.tgz 202ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/serve-static/-/serve-static-2.2.1.tgz 202ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/send/-/send-1.2.1.tgz 204ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/bytes/-/bytes-3.1.2.tgz 207ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/negotiator/-/negotiator-1.1.0.tgz 208ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/router/-/router-2.2.0.tgz 211ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/iconv-lite/-/iconv-lite-0.7.3.tgz 212ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/toidentifier/-/toidentifier-1.0.1.tgz 223ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/once/-/once-1.4.0.tgz 222ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/on-finished/-/on-finished-2.4.2.tgz 224ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/range-parser/-/range-parser-1.3.0.tgz 224ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/parseurl/-/parseurl-1.3.3.tgz 224ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/http-errors/-/http-errors-2.0.1.tgz 231ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/merge-descriptors/-/merge-descriptors-2.0.0.tgz 231ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/fresh/-/fresh-2.0.0.tgz 232ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/etag/-/etag-1.8.1.tgz 232ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/proxy-addr/-/proxy-addr-2.0.8.tgz 233ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/qs/-/qs-6.17.1.tgz 236ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/escape-html/-/escape-html-1.0.3.tgz 243ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/encodeurl/-/encodeurl-2.0.1.tgz 243ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/finalhandler/-/finalhandler-2.1.1.tgz 247ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/body-parser/-/body-parser-2.4.0.tgz 259ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/content-type/-/content-type-2.1.0.tgz 262ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/cookie/-/cookie-0.7.2.tgz 264ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/depd/-/depd-2.0.0.tgz 264ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/accepts/-/accepts-2.0.0.tgz 265ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/cookie-signature/-/cookie-signature-1.2.2.tgz 265ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/content-disposition/-/content-disposition-2.0.1.tgz 265ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/mime-types/-/mime-types-3.0.2.tgz 267ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/debug/-/debug-4.4.3.tgz 266ms (cache miss)
npm http fetch GET 200 https://registry.npmjs.org/express/-/express-5.3.0.tgz 256ms (cache miss)
