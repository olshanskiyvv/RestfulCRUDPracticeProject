import React from "react";
import { IoCloseCircleSharp } from "react-icons/io5";
import { AiFillEdit } from "react-icons/ai";

class Weapon extends React.Component {
    weapon = this.props.weapon

    render() {
        return (<div className="weapon">
            <div className="icons">
                <AiFillEdit className="edit-icon"/>
                <IoCloseCircleSharp className="delete-icon"/>
            </div>
            <h3>Наименование: {this.displayData(this.weapon.name)}</h3>
            <div>Тип: {this.displayData(this.weapon.type)}</div>
            <div>Емкость магазина: {this.displayData(this.weapon.capacity)}</div>
            <div>Вес: {this.displayData(this.weapon.weight)}</div>
            <div>Дальность прицельной стрельбы (м): {this.displayData(this.weapon.sightingRange)}</div>
            <div>Скорострельность (выстр/мин): {this.displayData(this.weapon.rateOfFire)}</div>
        </div>)
    }

    displayData(data) {
        return data !== null ? data : "Не определено"
    }
}

export default Weapon;
