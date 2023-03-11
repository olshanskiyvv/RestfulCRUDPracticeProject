import React from "react";
import Weapon from "./Weapon";

class Weapons extends React.Component {
    render() {
        return (<div className="weapons">
            {this.props.weapons.map((weapon) => (
                <Weapon key={weapon.serialNumber} weapon={weapon} />
            ))}
        </div>)
    }
}

export default Weapons;
