CREATE TABLE IF NOT EXISTS Person (
	"PersonID" SERIAL PRIMARY KEY NOT NULL,
	"Firstname" VARCHAR(50) NOT NULL,
	"Lastname" VARCHAR(50) NOT NULL,
	"LogonName" VARCHAR(50) NULL DEFAULT NULL,
	"IsEmployee" BOOLEAN NOT NULL,
	"PhoneNumber" VARCHAR(20) NULL DEFAULT NULL,
	"EmailAddress" VARCHAR(256) NULL DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS Address (
	"AddressID" SERIAL PRIMARY KEY NOT NULL,
    "PersonID" INTEGER NULL,
	"Streetname" VARCHAR(50) NULL,
    "Housenumber" INTEGER NULL,
	"Postalcode" VARCHAR(50) NULL,
	"City" VARCHAR(50) NULL,
	"Region" VARCHAR(50) NULL,
	"Country" VARCHAR(50) NULL,
	"Geolocation" INTEGER NULL
);

CREATE TABLE IF NOT EXISTS Employee (
	"EmployeeID" SERIAL PRIMARY KEY  NOT NULL,
	"PersonID" INT NOT NULL,
	"Active" BOOLEAN DEFAULT FALSE,
	"Taskdescription" VARCHAR(256) NULL DEFAULT NULL,
	"JobTitle" VARCHAR(256) NULL DEFAULT NULL,
	"UserID" INT NULL
);

CREATE TABLE IF NOT EXISTS AppUser (
	"UserID" SERIAL PRIMARY KEY  NOT NULL,
	"Username" VARCHAR(30) NOT NULL,
	"Active" BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Customer (
	"CustomerID" SERIAL PRIMARY KEY  NOT NULL,
	"PersonID" INT NOT NULL,
	"AddressID" INT NOT NULL
);

CREATE TABLE IF NOT EXISTS SalesOrder (
	"OrderID" SERIAL PRIMARY KEY  NOT NULL,
	"CustomerID" INT NOT NULL,
	"ReadyForShipment" BOOLEAN NOT NULL DEFAULT FALSE,
	"AddressIDForDelivery" INT NOT NULL,
	"IsReturn" BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS SalesOrderline (
	"OrderID" INT NOT NULL,
	"lineId" SERIAL PRIMARY KEY  NOT NULL,
	"ArtID" INT NOT NULL,
	"Amount" DECIMAL NOT NULL,
	"Quantity" DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS Article (
	"ArtID" SERIAL PRIMARY KEY  NOT NULL,
	"Description" VARCHAR(50) NULL,
	"LongDescription" VARCHAR(256) NULL,
	"PackageAmount" DECIMAL NOT NULL,
	"PricePerPiece" DECIMAL NOT NULL,
	"PackagePrice" DECIMAL NOT NULL,
	"SizeM3" DECIMAL NOT NULL,
	"HeightCM" INT NOT NULL,
	"WidthCM" INT NOT NULL,
	"DepthCM" INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Shipmentlines (
	"ShipmentID" INT NOT NULL,
	"OrderID" INT NOT NULL,
	"RouteID" INT NULL DEFAULT NULL,
	"SizeM3" DECIMAL NOT NULL,
	"IsDelivered" BOOLEAN NOT NULL DEFAULT FALSE,
	"DriverID" INT NOT NULL,
	"DeliverDate" DATE NULL
);

CREATE TABLE IF NOT EXISTS Route (
	"RouteID" INT NOT NULL,
	"RouteName" VARCHAR(50) NOT NULL,
	"ShipmentID" INT NOT NULL,
	"TemplateRoute" BOOLEAN NOT NULL DEFAULT FALSE)