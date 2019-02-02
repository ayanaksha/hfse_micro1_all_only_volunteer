export SQL_DATABASE=group16b
export SQL_USER=group16b@group16b
export SQL_PASSWORD=Password123@
if [[ -z "${SQL_CI_URL}" ]]; then
 export SQL_CI_URL=jdbc:oracle:thin:@group16b.database.windows.net:1443:group16b
fi
