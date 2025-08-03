import React from 'react'
const element="Office Space"
const jsxatt=<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRclyyRuTf74BayM5S6TbahyK0Sz-5vS1_Ccw&s"
 width='25%' height='25%' alt='Office Space'/>
const itemName={Name:"DBS",Rent:90000,Address:"Chennai"}
const Office = () => {
    let colors = [];
  if (itemName.Rent <= 60000) {
    colors.push("textRed");
  } else {
    colors.push("textGreen");
  }

  return (
    <div className='details'>
        <h1>{element}, at Affortable Range</h1>
        {jsxatt}
        <h1>Name: {itemName.Name}</h1>
        <h3 className={colors.join(" ")}>Rent: Rs. {itemName.Rent}</h3>
        <h3>Address: {itemName.Address}</h3>
    </div>
  )
}

export default Office