use onshop;
INSERT INTO `User` VALUES (1, '1', '123', 'ROLE_USER', 'andres.mendez.cor@gmail.com'), (2, '1', '123', 'ROLE_ADMIN', 'amendez.contac@gmail.com'), (3, '1', '123', 'ROLE_VENDOR', 'acorchuelo@mum.edu');
INSERT INTO `Address` VALUES (1, 'city14123', 'country14123', '123state14123', 'street1123123', '110004123'), (2, 'city14', 'country14', 'state14', 'street14', '110004'), (3, 'city3', 'c3', 'state3', 'street3', '52556');
INSERT INTO `Administrator` VALUES (1, 'firstN1', 'lastNa1', '130-3333-2222', 0);
INSERT INTO `Customer` VALUES (1, 'firstName', 'lastName', '319-222-5555', 3, 3);
INSERT INTO `VendorCategory` VALUES (1);
INSERT INTO `Vendor` VALUES (1, 'firstN', 'lstN', 'name', '319-222-1111', 'status', 2, 1);

INSERT INTO `onshop`.`category` (`categoryID`, `categoryName`) VALUES ('1', 'Men\'s');
INSERT INTO `onshop`.`category` (`categoryID`, `categoryName`) VALUES ('2', 'Women\'s');
INSERT INTO `onshop`.`category` (`categoryID`, `categoryName`) VALUES ('3', 'Kids\'');

INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('1', '2', 'Pryma Headphones, Rose Gold & Grey', 'Pryma Headphones, Rose Gold & Grey', '180', '20', '1');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('2', '2', 'Fujifilm X100T 16 MP Digital Camera (Silver)', 'Fujifilm X100T 16 MP Digital Camera (Silver)', '350', '10', '1');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('3', '2', 'DYMO LabelWriter 450 Turbo Thermal Label Printer', 'DYMO LabelWriter 450 Turbo Thermal Label Printer', '90', '5', '2');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('4', '2', 'Pryma Headphones, Rose Gold & Grey', 'Pryma Headphones, Rose Gold & Grey', '50', '0', '2');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('5', '2', 'Fujifilm X100T 16 MP Digital Camera (Silver)', 'Fujifilm X100T 16 MP Digital Camera (Silver)', '35', '100', '2');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('6', '2', 'DYMO LabelWriter 450 Turbo Thermal Label Printer', 'DYMO LabelWriter 450 Turbo Thermal Label Printer', '20', '3', '3');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('7', '2', 'Pryma Headphones, Rose Gold & Grey', 'Pryma Headphones, Rose Gold & Grey', '999', '6', '3');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('8', '2', 'Fujifilm X100T 16 MP Digital Camera (Silver)', 'Fujifilm X100T 16 MP Digital Camera (Silver)', '59', '2000', '1');
INSERT INTO `onshop`.`product` (`productId`, `flag`, `productDescription`, `productName`, `productPrice`, `unitInStock`, `categoryId`) VALUES ('9', '2', 'DYMO LabelWriter 450 Turbo Thermal Label Printer', 'DYMO LabelWriter 450 Turbo Thermal Label Printer', '29', '20', '2');
