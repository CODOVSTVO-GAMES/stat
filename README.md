.\mvnw clean install -DskipTests=true

sudo mvn clean install -DskipTests=true -e

docker-compose build
docker-compose up

sudo chmod +x start.sh
sudo sed -i -e 's/\r$//' start.sh
sudo ./start.sh

sudo chmod +x debug.sh
sudo sed -i -e 's/\r$//' debug.sh
sudo ./debug.sh