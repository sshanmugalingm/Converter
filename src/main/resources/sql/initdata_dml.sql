--Currency Data

insert into Currency values (1,  'AUD', 'Australian Dollar', 2, 'Australia');
insert into Currency values (2,  'CAD', 'Canadian Dollar', 2, 'Canada');
insert into Currency values (3,  'CNY', 'Chinese Yuan Renminbi', 2, 'China');
insert into Currency values (4,  'CZK', 'Czech Koruna', 2, 'Czech Republic');
insert into Currency values (5,  'DKK', 'Danish Krone', 2, 'Denmark');
insert into Currency values (6,  'EUR', 'EU Euro', 2, 'Euro');
insert into Currency values (7,  'GBP', 'Great Britain Pound', 2, 'Great Britain');
insert into Currency values (8,  'JPY', 'Japanese Yen', 0, 'Japan');
insert into Currency values (9,  'NOK', 'Norwegian Krone', 2, 'Norway');
insert into Currency values (10, 'NZD', 'New Zealand Dollar', 2, 'New Zealand');
insert into Currency values (11, 'USD', 'US Dollar', 2, 'USA');

--Exchange Rate Data

insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (1, 1, 11, 0.8371);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (2, 2, 11, 0.8711);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (3, 11, 3, 6.1715);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (4, 6, 11, 1.2315);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (5, 7, 11, 1.5683);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (6, 10, 11, 0.7750);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (7, 11, 8, 119.95);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (8, 6, 4, 27.6028);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (9, 6, 5, 7.4405);
insert into ExchangeRate (id, baseCurrency_id, termCurrency_id, rate) values (10, 6, 9, 8.6651);

--Conversion Chart Data

--AUD to Others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (1, 'UNITY', 1, 1, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (2, 'CROSSCURRENCY', 1, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (3, 'CROSSCURRENCY', 1, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (4, 'CROSSCURRENCY', 1, 4, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (5, 'CROSSCURRENCY', 1, 5, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (6, 'CROSSCURRENCY', 1, 6, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (7, 'CROSSCURRENCY', 1, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (8, 'CROSSCURRENCY', 1, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (9, 'CROSSCURRENCY', 1, 9, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (10, 'CROSSCURRENCY', 1, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (11, 'DIRECT', 1, 11, null);

-- CAD to Others
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (12, 'CROSSCURRENCY', 2, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (13, 'UNITY', 2, 2, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (14, 'CROSSCURRENCY', 2, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (15, 'CROSSCURRENCY', 2, 4, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (16, 'CROSSCURRENCY', 2, 5, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (17, 'CROSSCURRENCY', 2, 6, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (18, 'CROSSCURRENCY', 2, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (19, 'CROSSCURRENCY', 2, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (20, 'CROSSCURRENCY', 2, 9, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (21, 'CROSSCURRENCY', 2, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (22, 'DIRECT', 2, 11, null);

-- CNY to Others
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (23, 'CROSSCURRENCY', 3, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (24, 'CROSSCURRENCY', 3, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (25, 'UNITY', 3, 3, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (26, 'CROSSCURRENCY', 3, 4, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (27, 'CROSSCURRENCY', 3, 5, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (28, 'CROSSCURRENCY', 3, 6, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (29, 'CROSSCURRENCY', 3, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (30, 'CROSSCURRENCY', 3, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (31, 'CROSSCURRENCY', 3, 9, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (32, 'CROSSCURRENCY', 3, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (33, 'INVERSE', 3, 11, null);

-- CZK to Others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (34, 'CROSSCURRENCY', 4, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (35, 'CROSSCURRENCY', 4, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (36, 'CROSSCURRENCY', 4, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (37, 'UNITY', 4, 4, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (38, 'CROSSCURRENCY', 4, 5, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (39, 'INVERSE', 4, 6, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (40, 'CROSSCURRENCY', 4, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (41, 'CROSSCURRENCY', 4, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (42, 'CROSSCURRENCY', 4, 9, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (43, 'CROSSCURRENCY', 4, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (44, 'CROSSCURRENCY', 4, 11, 6);

-- DKK to Others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (45, 'CROSSCURRENCY', 5, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (46, 'CROSSCURRENCY', 5, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (47, 'CROSSCURRENCY', 5, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (48, 'CROSSCURRENCY', 5, 4, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (49, 'UNITY', 5, 5, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (50, 'INVERSE', 5, 6, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (51, 'CROSSCURRENCY', 5, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (52, 'CROSSCURRENCY', 5, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (53, 'CROSSCURRENCY', 5, 9, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (54, 'CROSSCURRENCY', 5, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (55, 'CROSSCURRENCY', 5, 11, 6);

-- EUR to others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (56, 'CROSSCURRENCY', 6, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (57, 'CROSSCURRENCY', 6, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (58, 'CROSSCURRENCY', 6, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (59, 'DIRECT', 6, 4, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (60, 'DIRECT', 6, 5, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (61, 'UNITY', 6, 6, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (62, 'CROSSCURRENCY', 6, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (63, 'CROSSCURRENCY', 6, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (64, 'DIRECT', 6, 9, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (65, 'CROSSCURRENCY', 6, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (66, 'DIRECT', 6, 11, null);

-- GBP to others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (67, 'CROSSCURRENCY', 7, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (68, 'CROSSCURRENCY', 7, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (69, 'CROSSCURRENCY', 7, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (70, 'CROSSCURRENCY', 7, 4, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (71, 'CROSSCURRENCY', 7, 5, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (72, 'CROSSCURRENCY', 7, 6, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (73, 'UNITY', 7, 7, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (74, 'CROSSCURRENCY', 7, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (75, 'CROSSCURRENCY', 7, 9, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (76, 'CROSSCURRENCY', 7, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (77, 'DIRECT', 7, 11, null);

--JPY to others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (78, 'CROSSCURRENCY', 8, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (79, 'CROSSCURRENCY', 8, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (80, 'CROSSCURRENCY', 8, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (81, 'CROSSCURRENCY', 8, 4, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (82, 'CROSSCURRENCY', 8, 5, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (83, 'CROSSCURRENCY', 8, 6, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (84, 'CROSSCURRENCY', 8, 7, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (85, 'UNITY', 8, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (86, 'CROSSCURRENCY', 8, 9, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (87, 'CROSSCURRENCY', 8, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (88, 'INVERSE', 8, 11, null);

--NOK to others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (89, 'CROSSCURRENCY', 9, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (90, 'CROSSCURRENCY', 9, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (91, 'CROSSCURRENCY', 9, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (92, 'CROSSCURRENCY', 9, 4, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (93, 'CROSSCURRENCY', 9, 5, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (94, 'INVERSE', 9, 6, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (95, 'CROSSCURRENCY', 9, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (96, 'CROSSCURRENCY', 9, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (97, 'UNITY', 9, 9, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (98, 'CROSSCURRENCY', 9, 10, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (99, 'CROSSCURRENCY', 9, 11, 6);

--NZD to others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (100, 'CROSSCURRENCY', 10, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (101, 'CROSSCURRENCY', 10, 2, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (102, 'CROSSCURRENCY', 10, 3, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (103, 'CROSSCURRENCY', 10, 4, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (104, 'CROSSCURRENCY', 10, 5, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (105, 'CROSSCURRENCY', 10, 6, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (106, 'CROSSCURRENCY', 10, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (107, 'CROSSCURRENCY', 10, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (108, 'CROSSCURRENCY', 10, 9, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (109, 'UNITY', 10, 10, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (110, 'DIRECT', 10, 11, null);

--USD to others

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (111, 'INVERSE', 11, 1, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (112, 'INVERSE', 11, 2, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (113, 'DIRECT', 11, 3, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (114, 'CROSSCURRENCY', 11, 4, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (115, 'CROSSCURRENCY', 11, 5, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (116, 'INVERSE', 11, 6, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (117, 'INVERSE', 11, 7, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (118, 'DIRECT', 11, 8, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (119, 'CROSSCURRENCY', 11, 9, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (120, 'INVERSE', 11, 10, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (121, 'UNITY', 11, 11, null);