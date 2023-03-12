import React from "react";

class Header extends React.Component {
    render() {
        return (<header>
            <h2>{this.props.title}</h2>
        </header>)
    }
}

export default Header;
