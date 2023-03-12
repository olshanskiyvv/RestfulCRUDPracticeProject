import React from "react";
import { IoCloseCircleSharp } from "react-icons/io5";
import { AiFillEdit } from "react-icons/ai";
import WeaponForm from "./WeaponForm";

class Weapon extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            weapon: this.props.weapon,
            isEditing: false,
        }
    }

    render() {
        return (<div className="weapon">
            <div className="icons">
                <AiFillEdit onClick={() => {
                    this.setState({
                        isEditing: !this.state.isEditing
                    })
                }} className="edit-icon"/>
                <IoCloseCircleSharp onClick={() => this.props.onDelete(this.state.weapon.serialNumber)} className="delete-icon"/>
            </div>
            <h3>Наименование: {this.displayData(this.state.weapon.name)}</h3>
            <div>Тип: {this.displayData(this.state.weapon.type)}</div>
            <div>Емкость магазина: {this.displayData(this.state.weapon.capacity)}</div>
            <div>Вес: {this.displayData(this.state.weapon.weight)}</div>
            <div>Дальность прицельной стрельбы (м): {this.displayData(this.state.weapon.sightingRange)}</div>
            <div>Скорострельность (выстр/мин): {this.displayData(this.state.weapon.rateOfFire)}</div>
            {this.state.isEditing && (<div className="form">
                Введите данные только в те поля, которые хотите изменить:
                <WeaponForm toDo={this.props.onEdit} weapon={this.state.weapon} buttonText="Сохранить"/>
            </div>)}
        </div>)
    }

    displayData(data) {
        return data !== null ? data : "Не определено"
    }
}

export default Weapon;
