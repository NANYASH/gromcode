CREATE TABLE ORDER_T (
  ID         NUMBER PRIMARY KEY,
  DATE_FROM  DATE NOT NULL,
  DATE_TO    DATE NOT NULL,
  MONEY_PAID NUMBER,
  ID_USER    NUMBER,
  FOREIGN KEY(ID_USER) REFERENCES USER_T(ID),
  ID_ROOM    NUMBER,
  FOREIGN KEY(ID_ROOM) REFERENCES ROOM(ID)
)


