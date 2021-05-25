CREATE DATABASE centroautomotriz;
CREATE USER 'centroAutoUser'@'localhost'
IDENTIFIED BY 'centroAutoUser';
GRANT ALL ON centroautomotriz.* TO 'centroAutoUser'@'localhost';