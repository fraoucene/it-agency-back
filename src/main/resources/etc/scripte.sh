#!/bin/bash
FILES='C:\Users\fguezout\Desktop\spring-boot-rest-api-postgresql\src\main\resources\etc\sql'
FILES='C:\Users\fguezout\Desktop\info-tech-agency-back\src\main\resources\etc\sql'
for f in $FILES
do
  echo "Processing $f file..."
  psql -U postgres -d db_it_agency -a -f $f
done