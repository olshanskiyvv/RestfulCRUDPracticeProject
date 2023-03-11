import React from "react";

class WeaponForm extends React.Component {
    render() {
        return (
            <form>
                <input placeholder="Наименование оружия"/>
                <input placeholder="Тип оружия"/>
                <input placeholder="Емкость магазина"/>
                <input placeholder="Вес"/>
                <input placeholder="Дальность причельносй стрельбы (м)"/>
                <input placeholder="Скорострельность (выстр/мин)"/>
                <button type="button">{this.props.buttonText}</button>
            </form>
        )
    }
}

export default WeaponForm;
