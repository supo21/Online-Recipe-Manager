document.addEventListener('DOMContentLoaded', function() {
    const foodItems = [
        { name: "Pizza", img: "images/pizza.jpg" },
        { name: "Burger", img: "images/burger.jpg" },
        { name: "Pasta", img: "images/pasta.jpg" }
    ];

    const coldDrinks = [
        { name: "Lemonade", img: "images/lemonade.jpg" },
        { name: "Iced Coffee", img: "images/icedcoffee.jpg" },
        { name: "Smoothie", img: "images/smoothie.jpg" }
    ];

    function displayItems(items, containerId) {
        const container = document.getElementById(containerId);
        items.forEach(item => {
            const itemDiv = document.createElement('div');
            itemDiv.className = 'item';
            itemDiv.innerHTML = `
                <h4>${item.name}</h4>
                <img src="${item.img}" alt="${item.name}">
            `;
            container.appendChild(itemDiv);
        });
    }

    displayItems(foodItems, 'food-items');
    displayItems(coldDrinks, 'cold-drinks');
});
