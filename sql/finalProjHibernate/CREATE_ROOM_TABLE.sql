CREATE TABLE ROOM (
  ID         NUMBER PRIMARY KEY,
  NUMBER_OF_GUESTS      NUMBER NOT NULL,
  PRICE                 DECIMAL NOT NULL,
  BREAKFAST_INCLUDED    NUMBER (1,0) DEFAULT 0 NOT NULL,
  PETS_ALLOWED          NUMBER (1,0) DEFAULT 0 NOT NULL,
  DATE_AVAILABLE_FROM   DATE NOT NULL,
  ID_HOTEL   NUMBER,
  FOREIGN KEY(ID_HOTEL) REFERENCES HOTEL(ID)
  )