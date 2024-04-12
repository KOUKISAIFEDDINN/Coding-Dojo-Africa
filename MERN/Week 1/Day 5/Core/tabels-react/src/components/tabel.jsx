import React from "react";

const Tabs = (props) => {
    //const [currentTab, setCurrentTab] = useState(1);

    const tabsArray = (value) => {
        const arr = [];
        for (let i = 1; i <= value; i++) {
            arr.push(i);
        }
        return arr;
    };
    return tabsArray(props.tabsNumber).map((num, i) => (
        <button
            key={i}
            onClick={() => {
                //setCurrentTab(num);
                console.log(num);
                //props.tabContent(currentTab);
                props.tabContent(num);
            }}
        >
            Tab{num}
        </button>
    ));
};
export default Tabs;