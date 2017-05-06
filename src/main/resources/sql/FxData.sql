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

insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (1, 'CROSSCURRENCY', 8, 9, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (2, 'INVERSE', 8, 11, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (3, 'CROSSCURRENCY', 11, 9, 6);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (4, 'INVERSE', 11, 6, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (5, 'DIRECT', 6, 9, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (6, 'DIRECT', 1, 11, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (7, 'CROSSCURRENCY', 1, 8, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (8, 'DIRECT', 11, 8, null);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (9, 'CROSSCURRENCY', 8, 1, 11);
insert into ConversionChart (id , conversionType, sourceCurrency_id, destinationCurrency_id, referenceCurrency_id) values (10, 'INVERSE', 11, 1, null);
