;             
CREATE USER IF NOT EXISTS SA SALT '1c0b944ad9b34258' HASH '59eb4c5f03ed072da041bf06af2f78da98bd7a361b8c24e4e46de668ee234bea' ADMIN;           
CREATE CACHED TABLE PUBLIC.T1(
    C1 DOUBLE,
    C2 DOUBLE
);             
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.T1;      
INSERT INTO PUBLIC.T1(C1, C2) VALUES
(1.23, 4.56);           
CREATE CACHED TABLE PUBLIC.T2(
    C1 DOUBLE,
    C2 DOUBLE
);             
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.T2;      
