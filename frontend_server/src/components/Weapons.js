import React from "react";
import Weapon from "./Weapon";

class Weapons extends React.Component {
    render() {
        if (this.props.weapons.length > 0)
            return (<div className="weapons">
                {this.props.weapons.map((weapon) => (
                    <Weapon onEdit={this.props.onEdit} onDelete={this.props.onDelete} key={weapon.serialNumber} weapon={weapon} />
                ))}
            </div>)
        else
            return <h2 className="weapons">Записей пока нет</h2>
    }
}

export default Weapons;
