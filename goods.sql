-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Ноя 29 2020 г., 12:36
-- Версия сервера: 10.4.14-MariaDB
-- Версия PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `goods`
--

-- --------------------------------------------------------

--
-- Структура таблицы `goodswh`
--

CREATE TABLE `goodswh` (
  `id_wh` int(11) NOT NULL,
  `id_gd` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `goodswh`
--

INSERT INTO `goodswh` (`id_wh`, `id_gd`, `id`) VALUES
(1, 2, 3),
(2, 1, 1),
(2, 3, 14),
(2, 5, 15),
(2, 6, 29),
(3, 2, 19),
(6, 6, 27);

-- --------------------------------------------------------

--
-- Структура таблицы `goods_main`
--

CREATE TABLE `goods_main` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `goods_main`
--

INSERT INTO `goods_main` (`id`, `name`) VALUES
(67, 'Among Us'),
(74, 'ghgfh'),
(70, 'test_upd'),
(3, 'Агуша'),
(2, 'Вискас для котят'),
(8, 'Игра \"Локалхост\"'),
(59, 'Мороженое \"ГУЛАГ\"'),
(60, 'Ржавая волга'),
(1, 'Фрутоняня'),
(5, 'Хот-дог \"Горячая собака\"'),
(7, 'Художественный фильм \"Стырили\"'),
(6, 'Шавуха');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `role`) VALUES
(1, 'admin', '$2y$12$SMbOvhC03W/oSK/oEGiLUOJRD/WD59WPbFsADIkO3J2XinlOMkpse', 'ADMIN'),
(4, 'Коробка из-под телевизора', '$2y$12$jUFwrW1t5TGwZg34Epo7iehQKHqqyCzJGL6EL7iDcwt2b0J45Us7G', 'USER'),
(5, 'Подвал', '$2y$12$nO0gY6Xc7yadTFaO9QFLcuS3dl9jEEtN14QI5wvxpdCBHJLPUbfKW', 'USER'),
(6, 'Кладовка', '$2y$12$SyJ5zT4Q4kxFXDTkVnfWueSpqxmlfogQP0Ib6U9ubfM3N.hcownbm', 'USER'),
(7, 'Старая банка из-под Nescafe', '$2y$12$6VxrromBHMU.yG2oSqXJbeeftJMiLKe8dGoSCD9uUt4hawsg8ES76', 'USER'),
(8, 'Тестовый склад', '$2a$12$6Wr4dPf6NCAUEeIOxaaNhOngKgq0cLZtaSwOAo7JqJyugSw1wCqVq', 'USER');

-- --------------------------------------------------------

--
-- Структура таблицы `warehouses`
--

CREATE TABLE `warehouses` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `warehouses`
--

INSERT INTO `warehouses` (`id`, `name`) VALUES
(2, 'Кладовка'),
(3, 'Коробка из-под телевизора'),
(1, 'Подвал'),
(6, 'Старая банка из-под Nescafe'),
(11, 'Тестовый склад');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `goodswh`
--
ALTER TABLE `goodswh`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `XAK1goodswh` (`id_wh`,`id_gd`),
  ADD KEY `R_4` (`id_gd`);

--
-- Индексы таблицы `goods_main`
--
ALTER TABLE `goods_main`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `XAK1goods_main` (`name`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_login_uindex` (`login`),
  ADD UNIQUE KEY `users_password_uindex` (`password`);

--
-- Индексы таблицы `warehouses`
--
ALTER TABLE `warehouses`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `XAK1warehouses` (`name`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `goodswh`
--
ALTER TABLE `goodswh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT для таблицы `goods_main`
--
ALTER TABLE `goods_main`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT для таблицы `warehouses`
--
ALTER TABLE `warehouses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `goodswh`
--
ALTER TABLE `goodswh`
  ADD CONSTRAINT `R_3` FOREIGN KEY (`id_wh`) REFERENCES `warehouses` (`id`),
  ADD CONSTRAINT `R_4` FOREIGN KEY (`id_gd`) REFERENCES `goods_main` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
