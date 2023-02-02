/*
* Spring Bootでは、src/main/resourcesディレクトリ下にschema.sql(DDL)とdata.sql(DML)という名前のファイルがあると、そのファイル内に書いてあるsqlをアプリ起動時に自動で実行してくれます。
*/
CREATE TABLE cash_card
(
    ID     BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    AMOUNT NUMBER NOT NULL DEFAULT 0
);
