CREATE DATABASE  IF NOT EXISTS `course_management`;
USE `course_management`;

-- Table structure for table `roles`
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` enum('ROLE_ADMIN','ROLE_MENTOR','ROLE_STUDENT') DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `roles` VALUES (1,'ROLE_STUDENT'),(2,'ROLE_MENTOR'),(3,'ROLE_ADMIN');

-- Table structure for table `user`
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birth_day` date DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `enable` bit(1) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `gender` bit(1) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user` 
VALUES 
('55e28e94-80a4-4457-a2f8-bdb658ea25bb',NULL,NULL,'2023-12-24','nguyenvanB@gmail.com',_binary '','Nguyễn Văn',_binary '\0',NULL,'B','$2a$10$AFbfo9V4fZCNVI8pm7Il9ucYjULpRIGMDac/774RXfTAoSy/RAS1u',NULL),('5ce8a049-6c42-47fa-a52e-0d3609866a30',NULL,NULL,'2023-12-21','phat@gmail.com',_binary '','Lê',_binary '\0',NULL,'Phát','$2a$10$rqdfCgAOcpozuqmuJu5z.elILqZs1XJtPb7MSoXvY/IceOnjUFAkG',NULL),
('6be558d9-76b5-41c2-a9ac-31106f4aa34e','',NULL,'2023-12-21','duc@gmail.com',_binary '\0','Đức',_binary '','','Vũ','$2a$10$v2YnfgfQQk4Dcp.M0OtOjea/DyWa5DHmelXZR3dKk58xf/XnvXR66',''),('7cf947f5-0bd0-49c4-8b27-ae5b5621bd5e','Nghệ An','1998-10-10','2023-12-21','hunghx@gmail.com',_binary '','Hung',_binary '\0','https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-21_16-19-36367002034_691188433047875_2280983879579520561_n.jpg?generation=1703150377274889&alt=media','Ho','$2a$10$JLquCERYDdDzoNd1rYXmveW.VN1duJlkeGrbJ4Wr1x17B7aGPV3zW','0932797890'),
('c90a7978-783a-4768-bacc-ed98cdefe03c','Tan Binh','1998-10-09','2023-12-23','ducvu@gmail.com',_binary '','Duc',_binary '','https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-25_10-21-063213.jpg?generation=1703474467790365&alt=media','VU','$2a$10$Wx3j9Ixjfnle/v9x9PGtcODvylKTSqhpc1.cUk5uP65LsAleBJGdq','0965333333');


-- Table structure for table `user_role`
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user_role` 
VALUES
('55e28e94-80a4-4457-a2f8-bdb658ea25bb',1),
('5ce8a049-6c42-47fa-a52e-0d3609866a30',1),
('6be558d9-76b5-41c2-a9ac-31106f4aa34e',1),
('7cf947f5-0bd0-49c4-8b27-ae5b5621bd5e',1),
('c90a7978-783a-4768-bacc-ed98cdefe03c',1);

-- Table structure for table `refresh_token`
DROP TABLE IF EXISTS `refresh_token`;
CREATE TABLE `refresh_token` (
  `user_id` varchar(255) NOT NULL,
  `expiry_date` datetime(6) NOT NULL,
  `token` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_r4k4edos30bx9neoq81mdvwph` (`token`),
  CONSTRAINT `FKfgk1klcib7i15utalmcqo7krt` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `category`
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `UK_lroeo5fvfdeg4hpicn4lw7x9b` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `category` 
VALUES 
(1,'Java Programing','Lập trình Back-End Java'),
(2,'JavaScript Programing','Lập trình Full-Stack JS'),
(3,'Software Development Concept','Các mô hình quy trình phần mềm tổng quát'),
(4,'Fundamentals','IT Basic');

-- Table structure for table `course`
DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` varchar(255) NOT NULL,
  `course_desc` text NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `duration` int NOT NULL,
  `image_course_url` mediumblob,
  `is_activated` bit(1) NOT NULL,
  `category_id` bigint DEFAULT NULL,
  `course_title` text NOT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `UK_9dll001xc2cip6hug6axoab0p` (`course_name`),
  KEY `FKkyes7515s3ypoovxrput029bh` (`category_id`),
  CONSTRAINT `FKkyes7515s3ypoovxrput029bh` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `course` 
VALUES
('12d97277-2eb5-4592-9521-8491e745c49c','Node.js là một môi trường chạy mã JavaScript phía máy chủ, sử dụng kiến trúc không đồng bộ và event-driven. Nó cho phép xử lý đồng thời nhiều yêu cầu và tác vụ, giúp tăng hiệu suất và dễ dàng phát triển ứng dụng web và mạng.','Node Js',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_14-20-14nodejs-development.jpg?generation=1703056815084265&alt=media',_binary '',2,'Lập trình ứng dụng Web Back-End với Node JS'),('187e33c5-2def-49e1-800f-e94f5f968630','JSP (JavaServer Pages) và Servlet là hai công nghệ quan trọng trong phát triển ứng dụng web sử dụng ngôn ngữ Java. Chúng cho phép xây dựng các trang web động và tương tác với người dùng thông qua giao diện web.','JSP – Servlet',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_10-56-42jsp-servlet.png?generation=1703044603590577&alt=media',_binary '',1,'Phát triển ứng dụng web với JSP và Servlet'),('241d1328-40d3-4a7d-a171-23b901eeb15f','JavaScript là một ngôn ngữ lập trình phía máy khách được sử dụng để tạo tính năng động và tương tác trên trang web. Nó cho phép thay đổi nội dung, kiểu dáng và tương tác với người dùng thông qua các sự kiện. JavaScript cũng hỗ trợ xử lý dữ liệu, gửi yêu cầu đến máy chủ và làm việc với các dịch vụ web khác.','Java Script',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_14-04-55javascript.png?generation=1703055896568170&alt=media',_binary '',2,'Lập trình Java Script cơ bản, nâng cao'),('387dbcfb-3857-4409-a822-dbbea145c334','Spring Framework là một framework phát triển ứng dụng Java mạnh mẽ và phổ biến. Nó cung cấp một cách tiếp cận linh hoạt cho việc xây dựng ứng dụng doanh nghiệp, từ ứng dụng web đến ứng dụng di động và các dịch vụ web. Spring Framework tập trung vào việc quản lý các thành phần và phụ thuộc, cung cấp tính năng IoC (Inversion of Control) và DI (Dependency Injection), và hỗ trợ các mô hình phát triển phổ biến như MVC (Model-View-Controller).','Spring Framework',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_10-59-55spring-framework.png?generation=1703044796415531&alt=media',_binary '',1,'Phát triển Java với Spring Framework'),('422daf3a-a4c6-414e-852c-ff2727834ae5','NestJS là một framework phía máy chủ (server-side) được xây dựng trên Node.js và TypeScript. Nó giúp xây dựng ứng dụng web phía máy chủ mạnh mẽ, dễ bảo trì và mở rộng. NestJS sử dụng cấu trúc module, dependency injection và decorators để tạo ra mã sạch và dễ kiểm thử. Nó hỗ trợ viết các API RESTful hoặc GraphQL và tích hợp thuận tiện với cơ sở dữ liệu và các thư viện khác. NestJS cung cấp một cách tổ chức dự án dễ sử dụng và đồng thời tận dụng được sức mạnh của TypeScript trong việc phát triển ứng dụng.','Nest Js',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_14-26-45nest-js.jpg?generation=1703057206815821&alt=media',_binary '',2,'Lập trình ứng dụng Web Back-End nâng cao với Nest JS'),('52f7c0f6-5cca-4f15-8be7-d8a5453b99dd','Java Network là một phần quan trọng của Java Development Kit (JDK) và cung cấp các công cụ và thư viện để phát triển ứng dụng mạng trong Java. Java Network cho phép bạn tạo các ứng dụng mạng, kết nối và giao tiếp với các máy chủ và thiết bị khác qua giao thức TCP/IP và UDP.','Java Network',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_10-37-41java-networking-tutorial.jpg?generation=1703043463004457&alt=media',_binary '',1,'Lập trình mạng với Socket Java'),('5ef90a86-ff6d-42ca-ae4d-e47dcb5d5539','ReactJS là một thư viện JavaScript mã nguồn mở phát triển bởi Facebook. Nó sử dụng một khái niệm gọi là \"component\" để xây dựng giao diện người dùng (UI) cho các ứng dụng web đơn trang (single-page applications) và ứng dụng di động. Mỗi component đại diện cho một phần tử độc lập trong giao diện, chẳng hạn như nút, biểu mẫu, danh sách hoặc bảng. Các component có thể được kết hợp vào nhau để tạo thành giao diện phức tạp.','React JS',200,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_13-56-35react-js.png?generation=1703055397040351&alt=media',_binary '',2,'Xây dựng Website với ReactJS'),('901594fa-a7f6-4d03-a9bf-29be72058011','Khóa học này giúp người học hiểu và nắm vững ngôn ngữ đánh dấu HTML, ngôn ngữ định dạng CSS và. Trong khóa học này, bạn sẽ được hướng dẫn từ cơ bản đến nâng cao về cú pháp, cấu trúc và các phần tử cơ bản,v.v...','HTML - CSS',86,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_14-04-49html-css.jpeg?generation=1703055890469597&alt=media',_binary '',2,'HTML, CSS từ zero đến hero'),('9591b8ce-e0f8-4da0-9d38-b010add9ca30','Java 8 là một phiên bản quan trọng của ngôn ngữ lập trình Java, được phát hành vào năm 2014. Nó mang đến nhiều tính năng mới và cải tiến quan trọng cho Java, mở ra một cách tiếp cận mới cho việc lập trình Java.','Java 8',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_10-46-06java8.png?generation=1703043967302974&alt=media',_binary '',1,'Tính năng mới trong Java 8'),('9994ef34-69e0-49a6-ac40-207e844b0c13','MongoDB là một hệ quản trị cơ sở dữ liệu phi quan hệ (NoSQL) linh hoạt, lưu trữ dữ liệu phi cấu trúc và có khả năng mở rộng tốt. Nó sử dụng cấu trúc dữ liệu JSON-like và cung cấp các truy vấn mạnh mẽ. MongoDB hỗ trợ replica set và sharding để đảm bảo khả năng chịu tải và chịu lỗi.','MongoDB',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_14-13-00mongodb.png?generation=1703056380920608&alt=media',_binary '',2,'Xây dựng Database với MongoDB'),('a3c3409b-33ca-44b4-b63d-85f53a8b9b6f','JDBC (Java Database Connectivity) và Hibernate là hai công nghệ quan trọng trong phát triển ứng dụng Java liên quan đến cơ sở dữ liệu. Cả JDBC và Hibernate đều được sử dụng để tương tác với cơ sở dữ liệu, nhưng có các cách tiếp cận khác nhau.','JDBC – Hibernate',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_11-09-48jdbc-hibernate.png?generation=1703045389639000&alt=media',_binary '',1,'Truy cập cơ sở dữ liệu với JDBC và Hibernate'),('da7a225a-70ac-442f-ae53-8f4a7253f050','Khóa học Java Core là một khóa học thiết yếu dành cho người mới bắt đầu học lập trình Java. Nó giúp bạn hiểu và làm quen với cú pháp, nguyên tắc cơ bản và các khái niệm quan trọng trong Java.','Java Core',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_10-32-58java-core.png?generation=1703043179730676&alt=media',_binary '',1,'Các khái niệm cơ bản và cú pháp của ngôn ngữ Java'),('e4f692f4-7f7f-4242-b189-1976db51c0e4','Java Multithreading là khả năng của Java để thực hiện nhiều luồng (threads) đồng thời trong một ứng dụng. Mỗi luồng đại diện cho một luồng thực thi độc lập trong quá trình chạy của ứng dụng. Multithreading cho phép các tác vụ được thực hiện song song, tận dụng tối đa tài nguyên của hệ thống và cải thiện hiệu suất và độ phản hồi của ứng dụng.','Java Multithreading',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_10-40-54java-multithreading.jpg?generation=1703043655277424&alt=media',_binary '',1,'Xử lý đa luồng trong Java và quản lý đồng bộ'),('eeaa3247-496a-4da5-b604-f434d3fcbeca','Hệ thống cơ sở dữ liệu (Database System) là một phần mềm được thiết kế để quản lý và tổ chức dữ liệu. Nó cung cấp các công cụ và chức năng để lưu trữ, truy xuất, cập nhật và xử lý dữ liệu một cách hiệu quả và an toàn. Hệ thống cơ sở dữ liệu đóng vai trò quan trọng trong việc quản lý thông tin và hỗ trợ các ứng dụng trong việc truy cập dữ liệu.','Database System',192,_binary 'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_10-50-42database-management-system.jpeg?generation=1703044243434468&alt=media',_binary '',1,'Xây dựng Database với MySQL');



-- Table structure for table `lesson`
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `lesson_id` bigint NOT NULL AUTO_INCREMENT,
  `content_link` text NOT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `unit_score` double DEFAULT NULL,
  `lesson_title` varchar(255) NOT NULL,
  PRIMARY KEY (`lesson_id`),
  KEY `FKjs3c7skmg8bvdddok5lc7s807` (`course_id`),
  CONSTRAINT `FKjs3c7skmg8bvdddok5lc7s807` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `lesson` 
VALUES (1,'https://storage.googleapis.com/download/storage/v1/b/sll-project-14-12-2023.appspot.com/o/2023-12-20_15-30-28?generation=1703061030158335&alt=media','187e33c5-2def-49e1-800f-e94f5f968630',0,'JSP - Lesson1');



-- Table structure for table `mentor`
DROP TABLE IF EXISTS `mentor`;
CREATE TABLE `mentor` (
  `user_id` varchar(255) NOT NULL,
  `degree` varchar(255) NOT NULL,
  `experience` int NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FKdijfp61kxqiqesthe4vwud31a` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `mentor_course`
DROP TABLE IF EXISTS `mentor_course`;
CREATE TABLE `mentor_course` (
  `course_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `FKr9c7obsc118rwh37f4yhqmudm` (`user_id`),
  CONSTRAINT `FKqg3421pir9c67dos2tqwo58ty` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FKr9c7obsc118rwh37f4yhqmudm` FOREIGN KEY (`user_id`) REFERENCES `mentor` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `question`
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` bigint NOT NULL AUTO_INCREMENT,
  `answer` enum('OPTION_A','OPTION_B','OPTION_C','OPTION_D') NOT NULL,
  `question_text` varchar(255) NOT NULL,
  `lesson_id` bigint DEFAULT NULL,
  `optiona` varchar(255) NOT NULL,
  `optionb` varchar(255) NOT NULL,
  `optionc` varchar(255) NOT NULL,
  `optiond` varchar(255) NOT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FK1sbknhfhhug49n0elkvgk38vs` (`lesson_id`),
  CONSTRAINT `FK1sbknhfhhug49n0elkvgk38vs` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`lesson_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO course_management.question (question_id, answer, optiona, optionb, optionc, optiond, question_text, lesson_id) VALUES (41, 'OPTION_A', 'A. Class', 'B. Object', 'C. Method', 'D. Package', 'What is the basic building block of Java?', 1);
INSERT INTO course_management.question (question_id, answer, optiona, optionb, optionc, optiond, question_text, lesson_id) VALUES (42, 'OPTION_C', 'A. public', 'B. private', 'C. protected', 'D. static', 'Which access modifier allows a class to be accessed from anywhere?', 1);
INSERT INTO course_management.question (question_id, answer, optiona, optionb, optionc, optiond, question_text, lesson_id) VALUES (43, 'OPTION_B', 'A. JVM', 'B. JRE', 'C. JDK', 'D. JAR', 'What is the software bundle that you need to develop, compile, and run Java programs?', 1);
INSERT INTO course_management.question (question_id, answer, optiona, optionb, optionc, optiond, question_text, lesson_id) VALUES (44, 'OPTION_D', 'A. Inheritance', 'B. Polymorphism', 'C. Abstraction', 'D. Encapsulation', 'Which feature of Java allows you to hide the internal implementation details of a class?', 1);
INSERT INTO course_management.question (question_id, answer, optiona, optionb, optionc, optiond, question_text, lesson_id) VALUES (45, 'OPTION_A', 'A. True', 'B. False', 'C. Maybe', 'D. None of the above', 'Java is a purely procedural programming language.', 1);
INSERT INTO course_management.question (question_id, answer, optiona, optionb, optionc, optiond, question_text, lesson_id) VALUES (54, 'OPTION_D', 'A. ArrayList', 'B. LinkedList', 'C. HashSet', 'D. HashMap', 'Which Java collection class allows you to store key-value pairs?', 1);
INSERT INTO course_management.question (question_id, answer, optiona, optionb, optionc, optiond, question_text, lesson_id) VALUES (57, 'OPTION_C', 'A. Polymorphism', 'B. Inheritance', 'C. Encapsulation', 'D. Abstraction', 'Which principle of object-oriented programming is associated with bundling data and methods within a single unit?', 1);

-- Table structure for table `student`
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `user_id` varchar(255) NOT NULL,
  `performance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FKk5m148xqefonqw7bgnpm0snwj` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `student_course_id` bigint NOT NULL AUTO_INCREMENT,
  `course_score` int DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `course_price` bigint DEFAULT NULL,
  PRIMARY KEY (`student_course_id`),
  KEY `FKejrkh4gv8iqgmspsanaji90ws` (`course_id`),
  KEY `FKkxgvdcdcr91p0767889qrbs7v` (`user_id`),
  CONSTRAINT `FKejrkh4gv8iqgmspsanaji90ws` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FKkxgvdcdcr91p0767889qrbs7v` FOREIGN KEY (`user_id`) REFERENCES `student` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Dumping data for table `student_course`
DROP TABLE IF EXISTS `student_question`;
CREATE TABLE `student_question` (
  `student_answer` enum('OPTION_A','OPTION_B','OPTION_C','OPTION_D') NOT NULL,
  `question_id` bigint NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`question_id`,`user_id`),
  KEY `FKe04feteq21spb5rns431qvuxq` (`user_id`),
  CONSTRAINT `FKe04feteq21spb5rns431qvuxq` FOREIGN KEY (`user_id`) REFERENCES `student` (`user_id`),
  CONSTRAINT `FKe8umv4156emxavp70fw9176m2` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;









