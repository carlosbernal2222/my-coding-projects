from datetime import datetime

#final variables 
menu = {
    "Cuban Sandwich": 8.50,
    "Medianoche": 8.00,
    "Croqueta Preparada": 9.50,
    "Pan con Bistec": 10.00,
    "Pan con Lechon": 9.00,
    "Ropa Vieja": 12.50,
    "Picadillo": 11.00,
    "Pollo a la Plancha": 12.00,
    "Arroz con Pollo": 13.00,
    "Lechon Asado": 14.00,
    "Yuca Frita": 5.00,
    "Tostones": 4.50,
    "Maduros": 4.50,
    "Empanada": 3.00,
    "Croqueta": 1.50,
    "Pastelito de Guayaba": 2.00,
    "Café Cubano": 1.50,
    "Café con Leche": 3.00,
    "Cortadito": 2.50,
    "Batido de Mamey": 4.00,
    "Batido de Mango": 4.00,
    "Jugo de Naranja": 3.50,
    "Jugo de Piña": 3.50,
    "Agua": 1.50,
    "Refresco": 2.00
}


#helper function to print receipt content
def receiptGen():

    subtotal = 0
    ordered_items = []

    while True:

        # Prompt user for input
        input_str = input("Enter item name and quantity ordered, separated by a space (type 'q' to quit): ")

        if input_str.lower() == 'q':
            break

        # Split input string into separate values
        name, quantity = input_str.split(",")

        #Remove any leading/trailing whitespace from name and convert quantity to an integer
        name = name.strip()
        quantity = int(quantity.strip())

        subtotal += menu[name] * quantity
        ordered_items.append((quantity, name, menu[name]))


    tax = taxCalculator(subtotal)
    total = subtotal + tax

    header()

    for item in ordered_items:
        print(f"{item[0]} {item[1]} @ ${item[2]:.2f} = ${(item[0]*item[2]):.2f}")

    print("\nSubtotal: $%.2f" % subtotal)
    print("Tax: $%.2f" % tax)
    print("Total: $%.2f" % total)


#header for receipt
def header():
    #variables
    restaurantName = "Gallin"
    address = "1821 Golden Gate Blvd West"
    cityState = "Naples, FL"
    phoneNumber = "(239)348-5275"
    now = datetime.now()
    dtString = now.strftime("%d/%m/%Y %H:%M:%S")

    print(restaurantName.center(30,'-'))
    print(address.center(30))
    print(cityState.center(30))
    print(phoneNumber.center(30))
    print("")
    print("SALE:")
    print(dtString.center(30))


#calculates tax amount of purchase
def taxCalculator(amount):
    
    taxPercentage = 7
    total = (amount*taxPercentage)/100

    return total

#Function to return the price associated with a menu item

#calling the function to generate a receipt
receiptGen()