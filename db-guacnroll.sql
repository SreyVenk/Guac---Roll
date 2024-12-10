-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 10, 2024 at 11:19 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `provider_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `drivers`
--

CREATE TABLE `drivers` (
  `id` bigint(20) NOT NULL,
  `available` bit(1) NOT NULL,
  `license_number` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `drivers`
--

INSERT INTO `drivers` (`id`, `available`, `license_number`, `name`, `email`) VALUES
(4, b'0', '7384697', 'driver', 'driver@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `inventory_item`
--

CREATE TABLE `inventory_item` (
  `inventory_item_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory_item`
--

INSERT INTO `inventory_item` (`inventory_item_id`, `name`, `price`, `quantity`) VALUES
(3, 'tacos', 300, 20),
(4, 'tacos', 700, 20);

-- --------------------------------------------------------

--
-- Table structure for table `inventory_item_seq`
--

CREATE TABLE `inventory_item_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory_item_seq`
--

INSERT INTO `inventory_item_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `total` double NOT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `order_type` varchar(255) NOT NULL,
  `driver_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `details`, `status`, `customer_name`, `total`, `delivery_address`, `order_type`, `driver_id`) VALUES
(52, 'Taco x 1 | Driver Assigned: test | Driver Assigned: test2', 'Completed', 'test', 3.99, NULL, 'Pickup', NULL),
(102, 'Taco x 5 | Driver Assigned: test5', 'Completed', 'test', 19.950000000000003, NULL, 'Pickup', NULL),
(152, 'Taco x 1', 'Cancelled', 'test', 3.99, NULL, 'Pickup', NULL),
(202, 'Burrito x 1', 'Pending', 'test123', 7.99, NULL, 'Pickup', NULL),
(252, 'Taco x 1', 'Pending', 'test', 3.99, NULL, 'Pickup', NULL),
(302, 'Taco x 1', 'Pending', 'Ur mom ', 3.99, 'wqiosfnfnoaf', 'Delivery', NULL),
(303, 'Taco x 3, Salad Bowl x 2 | Driver Assigned: driver', 'Pending', 'example', 22.950000000000003, 'my house', 'Delivery', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orders_seq`
--

CREATE TABLE `orders_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders_seq`
--

INSERT INTO `orders_seq` (`next_val`) VALUES
(401);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `stock` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `description`, `name`, `price`, `image_url`, `stock`) VALUES
(1, 'A delicious taco!', 'Taco', 3.99, '/images/taco.png', 10),
(2, 'A hearty burrito', 'Burrito', 7.99, '/images/burrito.png', 37),
(3, 'A flavorful bowl', 'Bowl', 6.99, '/images/bowl.png', 10),
(4, 'A cheesy quesadilla', 'Quesadilla', 5.99, '/images/quesadilla.png', 10),
(6, 'A fresh salad bowl', 'Salad Bowl', 5.49, '/images/salad.png', 10),
(7, 'Crispy chips with guacamole', 'Chips & Dip', 3.49, '/images/chips.png', 10);

-- --------------------------------------------------------

--
-- Table structure for table `provider`
--

CREATE TABLE `provider` (
  `provider_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `provider_seq`
--

CREATE TABLE `provider_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provider_seq`
--

INSERT INTO `provider_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `review_id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) NOT NULL,
  `rating` int(11) NOT NULL,
  `provider_reply` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`review_id`, `comment`, `customer_name`, `rating`, `provider_reply`) VALUES
(102, 'I really liked the burrito.', 'test', 5, 'im glad you like it '),
(152, 'testing this review', 'test', 5, NULL),
(153, 'testing this review', 'test', 3, NULL),
(202, 'this is a test', 'test', 3, NULL),
(252, 'i did it ', 'finally', 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `reviews_seq`
--

CREATE TABLE `reviews_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews_seq`
--

INSERT INTO `reviews_seq` (`next_val`) VALUES
(401);

-- --------------------------------------------------------

--
-- Table structure for table `rewards`
--

CREATE TABLE `rewards` (
  `reward_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rewards_seq`
--

CREATE TABLE `rewards_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rewards_seq`
--

INSERT INTO `rewards_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_banned` tinyint(1) NOT NULL DEFAULT 0,
  `suspended_until` tinyint(1) DEFAULT NULL,
  `banned` bit(1) NOT NULL,
  `suspended` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `is_banned`, `suspended_until`, `banned`, `suspended`) VALUES
(1, 'test@gmail.com', 'test123', 0, NULL, b'0', b'0'),
(2, 'admin@gmail.com', 'admin', 0, 0, b'0', b'0'),
(3, 'provider@gmail.com', 'provider', 0, 0, b'0', b'0'),
(4, 'distributor@gmail.com', 'distributor', 0, 0, b'0', b'0'),
(5, 'test2@gmail.com', 'test', 0, NULL, b'0', b'0'),
(6, 'example@gmail.com', 'example', 0, NULL, b'0', b'0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drivers`
--
ALTER TABLE `drivers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKcr60ij36fuvtcb87298g6rct6` (`license_number`),
  ADD UNIQUE KEY `UKre66mdta4hy6pxm2w1rqu08jv` (`email`);

--
-- Indexes for table `inventory_item`
--
ALTER TABLE `inventory_item`
  ADD PRIMARY KEY (`inventory_item_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `fk_driver` (`driver_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `provider`
--
ALTER TABLE `provider`
  ADD PRIMARY KEY (`provider_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`review_id`);

--
-- Indexes for table `rewards`
--
ALTER TABLE `rewards`
  ADD PRIMARY KEY (`reward_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `drivers`
--
ALTER TABLE `drivers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=304;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `review_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=303;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_driver` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
