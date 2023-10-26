-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: animals_db
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animal_breed_items`
--

DROP TABLE IF EXISTS `animal_breed_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_breed_items` (
  `breed_id` int NOT NULL AUTO_INCREMENT,
  `breed_item_id` int NOT NULL,
  PRIMARY KEY (`breed_id`),
  UNIQUE KEY `UK_nnitupmtxls714b9axp2bsvy2` (`breed_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_breed_items`
--

LOCK TABLES `animal_breed_items` WRITE;
/*!40000 ALTER TABLE `animal_breed_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal_breed_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_breeds`
--

DROP TABLE IF EXISTS `animal_breeds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_breeds` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rp0rbcjjocpwfc7o2wovs0cb2` (`name`),
  KEY `FK156b5f8ing2ypy4oeefmbk98m` (`type_id`),
  CONSTRAINT `FK156b5f8ing2ypy4oeefmbk98m` FOREIGN KEY (`type_id`) REFERENCES `animal_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_breeds`
--

LOCK TABLES `animal_breeds` WRITE;
/*!40000 ALTER TABLE `animal_breeds` DISABLE KEYS */;
INSERT INTO `animal_breeds` VALUES (50,'appenzeller',1),(1010,'affenpinscher',1),(1011,'african',1),(1012,'airedale',1),(1013,'akita',1),(1014,'australian shepherd',1),(1015,'basenji',1),(1016,'beagle',1),(1017,'bluetick',1),(1018,'borzoi',1),(1019,'bouvier',1),(1020,'boxer',1),(1021,'brabancon',1),(1022,'briard',1),(1023,'buhund norwegian',1),(1024,'bulldog boston',1),(1025,'bulldog english',1),(1026,'bulldog french',1),(1027,'bullterrier staffordshire',1),(1028,'cattledog australian',1),(1029,'chihuahua',1),(1030,'chow',1),(1031,'clumber',1),(1032,'cockapoo',1),(1033,'collie border',1),(1034,'coonhound',1),(1035,'corgi cardigan',1),(1036,'cotondetulear',1),(1037,'dachshund',1),(1038,'dalmatian',1),(1039,'dane great',1),(1040,'deerhound scottish',1),(1041,'dhole',1),(1042,'dingo',1),(1043,'doberman',1),(1044,'elkhound norwegian',1),(1045,'entlebucher',1),(1046,'eskimo',1),(1047,'finnish lapphund',1),(1048,'frise bichon',1),(1049,'germanshepherd',1),(1050,'greyhound italian',1),(1051,'groenendael',1),(1052,'havanese',1),(1053,'hound afghan',1),(1054,'hound basset',1),(1055,'hound blood',1),(1056,'hound english',1),(1057,'hound ibizan',1),(1058,'hound plott',1),(1059,'hound walker',1),(1060,'husky',1),(1061,'keeshond',1),(1062,'kelpie',1),(1063,'komondor',1),(1064,'kuvasz',1),(1065,'labradoodle',1),(1066,'labrador',1),(1067,'leonberg',1),(1068,'lhasa',1),(1069,'malamute',1),(1070,'malinois',1),(1071,'maltese',1),(1072,'mastiff bull',1),(1073,'mastiff english',1),(1074,'mastiff tibetan',1),(1075,'mexicanhairless',1),(1076,'mix',1),(1077,'mountain bernese',1),(1078,'mountain swiss',1),(1079,'newfoundland',1),(1080,'otterhound',1),(1081,'ovcharka caucasian',1),(1082,'papillon',1),(1083,'pekinese',1),(1084,'pembroke',1),(1085,'pinscher miniature',1),(1086,'pitbull',1),(1087,'pointer german',1),(1088,'pointer germanlonghair',1),(1089,'pomeranian',1),(1090,'poodle medium',1),(1091,'poodle miniature',1),(1092,'poodle standard',1),(1093,'poodle toy',1),(1094,'pug',1),(1095,'puggle',1),(1096,'pyrenees',1),(1097,'redbone',1),(1098,'retriever chesapeake',1),(1099,'retriever curly',1),(1100,'retriever flatcoated',1),(1101,'retriever golden',1),(1102,'ridgeback rhodesian',1),(1103,'rottweiler',1),(1104,'saluki',1),(1105,'samoyed',1),(1106,'schipperke',1),(1107,'schnauzer giant',1),(1108,'schnauzer miniature',1),(1109,'segugio italian',1),(1110,'setter english',1),(1111,'setter gordon',1),(1112,'setter irish',1),(1113,'sharpei',1),(1114,'sheepdog english',1),(1115,'sheepdog shetland',1),(1116,'shiba',1),(1117,'shihtzu',1),(1118,'spaniel blenheim',1),(1119,'spaniel brittany',1),(1120,'spaniel cocker',1),(1121,'spaniel irish',1),(1122,'spaniel japanese',1),(1123,'spaniel sussex',1),(1124,'spaniel welsh',1),(1125,'spitz japanese',1),(1126,'springer english',1),(1127,'stbernard',1),(1128,'terrier american',1),(1129,'terrier australian',1),(1130,'terrier bedlington',1),(1131,'terrier border',1),(1132,'terrier cairn',1),(1133,'terrier dandie',1),(1134,'terrier fox',1),(1135,'terrier irish',1),(1136,'terrier kerryblue',1),(1137,'terrier lakeland',1),(1138,'terrier norfolk',1),(1139,'terrier norwich',1),(1140,'terrier patterdale',1),(1141,'terrier russell',1),(1142,'terrier scottish',1),(1143,'terrier sealyham',1),(1144,'terrier silky',1),(1145,'terrier tibetan',1),(1146,'terrier toy',1),(1147,'terrier welsh',1),(1148,'terrier westhighland',1),(1149,'terrier wheaten',1),(1150,'terrier yorkshire',1),(1151,'tervuren',1),(1152,'vizsla',1),(1153,'waterdog spanish',1),(1154,'weimaraner',1),(1155,'whippet',1),(1156,'wolfhound irish',1),(1157,'Welsh terrier1111',1),(1158,'cavapoo',1);
/*!40000 ALTER TABLE `animal_breeds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_images`
--

DROP TABLE IF EXISTS `animal_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `animal_id` bigint NOT NULL,
  `file_path` varchar(256) NOT NULL,
  `type` enum('png','jpeg') DEFAULT NULL,
  `size` bigint NOT NULL,
  `created` timestamp NOT NULL,
  `updated` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `animal_id` (`animal_id`),
  CONSTRAINT `animal_images_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `animals` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_images`
--

LOCK TABLES `animal_images` WRITE;
/*!40000 ALTER TABLE `animal_images` DISABLE KEYS */;
INSERT INTO `animal_images` VALUES
(13,1,'W:\\Java study\\Java Super Pro\\uploadImages\\Sertificate Hillel Basic.png','png',310346,'2023-08-28 12:40:53','2023-08-28 12:40:53'),
(14,1,'W:\\Java study\\Java Super Pro\\uploadImages\\Sertificate Hillel Basic.png','png',310346,'2023-08-28 13:15:31','2023-08-28 13:15:31'),
(15,1,'W:\\Java study\\Java Super Pro\\uploadImages\\Sertificate Hillel Basic.png','png',310346,'2023-08-28 13:33:54','2023-08-28 13:33:54'),
(16,1,'W:\\Java study\\Java Super Pro\\uploadImages\\Sertificate Hillel Basic.png','png',310346,'2023-08-28 13:34:42','2023-08-28 13:34:42'),
(18,1,'W:\\Java study\\Java Super Pro\\uploadImages\\q3_wallpaper_211100_1_1024.jpg','jpeg',201208,'2023-08-28 14:18:47','2023-08-29 13:17:20'),
(20,1,'W:\\Java study\\Java Super Pro\\uploadImages\\IMG_20160518_174022.jpg','jpeg',979734,'2023-08-28 14:27:51','2023-08-28 14:27:51'),
(21,1,'W:\\Java study\\Java Super Pro\\uploadImages\\IMG_20160518_174022.jpg','jpeg',979734,'2023-08-28 14:39:52','2023-08-28 14:39:52'),
(22,1,'W:\\Java study\\Java Super Pro\\uploadImages\\IMG_20160518_174022.jpg','jpeg',979734,'2023-08-28 14:55:20','2023-08-28 14:55:20'),
(24,1,'W:\\Java study\\Java Super Pro\\uploadImages\\quake_3_team_arena_01_1024.jpg','jpeg',189083,'2023-08-29 13:24:21','2023-08-29 13:29:20'),
(25,1,'W:\\Java study\\Java Super Pro\\uploadImages\\Portal.jpg','jpeg',99817,'2023-08-29 16:51:23','2023-09-12 10:14:51'),
(26,1,'W:\\Java study\\Java Super Pro\\uploadImages\\Sertificate Hillel Basic.png','png',310346,'2023-08-30 09:07:49','2023-08-30 09:07:49'),
(27,3,'W:\\Java study\\Java Super Pro\\uploadImages\\Doom1.jpg','jpeg',153947,'2023-08-30 13:02:33','2023-08-30 13:02:33'),
(28,3,'W:\\Java study\\Java Super Pro\\uploadImages\\Doom1.jpg','jpeg',153947,'2023-08-30 13:41:19','2023-08-30 13:41:19'),
(29,3,'W:\\Java study\\Java Super Pro\\uploadImages\\Doom1.jpg','jpeg',153947,'2023-08-30 13:44:56','2023-08-30 13:44:56'),
(30,3,'W:\\Java study\\Java Super Pro\\uploadImages\\q3_wallpaper_211100_2_1024.jpg','jpeg',164205,'2023-09-06 13:49:33','2023-09-06 13:49:33'),
(36,3,'W:\\Java study\\Java Super Pro\\uploadImages\\matrix (q3).jpg','jpeg',102928,'2023-09-12 11:31:21','2023-09-12 11:31:21'),
(37,3,'W:\\Java study\\Java Super Pro\\uploadImages\\crash(dm7).jpg','jpeg',498137,'2023-09-12 11:38:22','2023-09-12 11:38:22'),
(38,3,'W:\\Java study\\Java Super Pro\\uploadImages\\quake3_team_arena_1.jpg','jpeg',339674,'2023-09-12 13:37:57','2023-09-12 13:37:57'),
(40,3,'W:\\Java study\\Java Super Pro\\uploadImages\\quake3_003.jpg','jpeg',43484,'2023-09-12 13:57:35','2023-09-12 13:57:35');
/*!40000 ALTER TABLE `animal_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_types`
--

DROP TABLE IF EXISTS `animal_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dci0aydxpw73iqi7f8h3eyun6` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_types`
--

LOCK TABLES `animal_types` WRITE;
/*!40000 ALTER TABLE `animal_types` DISABLE KEYS */;
INSERT INTO `animal_types` VALUES (2,'Cat'),(4,'Cow'),(1,'Dog'),(5,'Rabbit'),(13,'Snake'),(10,'Snake1'),(23,'SuperSnake1'),(15,'TestPuT'),(7,'Tiger'),(3,'Wolf');
/*!40000 ALTER TABLE `animal_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animals`
--

DROP TABLE IF EXISTS `animals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animals` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text NOT NULL,
  `breed_id` int NOT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `breed_id` (`breed_id`),
  CONSTRAINT `animals_ibfk_1` FOREIGN KEY (`breed_id`) REFERENCES `animal_breeds` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals`
--

LOCK TABLES `animals` WRITE;
/*!40000 ALTER TABLE `animals` DISABLE KEYS */;
INSERT INTO `animals` VALUES (1,'Black','Super Dog',1011,'2023-08-22 07:18:11','2023-08-22 07:18:11'),(3,'Tiger Updated Sensey!!!!','Tiger 5!!!!!',1011,'2023-08-22 07:45:17','2023-08-30 09:07:18');
/*!40000 ALTER TABLE `animals` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `animal_breed_items`;
--
-- Dumping events for database 'animals_db'
--

--
-- Dumping routines for database 'animals_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-17 16:48:40
