#!/bin/sh
curl --location --request POST 'http://localhost:8080/code/users' \
--form 'source=ZIB' \
--form 'codeListCode=ZIB001' \
--form 'code=271636001' \
--form 'displayValue=Polsslag regelmatig' \
--form 'longDescription=The long description is necessary' \
--form 'fromDate=01-01-2019' \
--form 'toDate=' \
--form 'sortingPriority=1' \


curl --location --request POST 'http://localhost:8080/code/users' \
--form 'source=ZIB' \
--form 'codeListCode=ZIB001' \
--form 'code=61086009' \
--form 'displayValue=Polsslag onregelmatig"' \
--form 'longDescription=' \
--form 'fromDate=01-01-2019' \
--form 'toDate=' \
--form 'sortingPriority=2'