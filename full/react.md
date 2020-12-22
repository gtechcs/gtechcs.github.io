# React

## Core React

1. ### React Glossary
    Open source, reusable UI components, Virtual DOM, JSX (html + code), server-side rendering, uni-directional data flow using Props, State, Arrow functions ES6, Handling events using bind, 
    render() each React component must have one render(); must return one element.  
    State each component can keep state. accessed via this.state(), set using setState()  
    All React components must act like pure functions with respect to their props.  
    


2. ### 
```
    ReactDOM.render(
        <h1>Hello, world!</h1>,
        document.getElementById('root')
    );

    <div id="root"></div>
    function tick() {
        const element = (
            <h1>Hello, world</h1>;
            <h2>It is {new Date().toLocaleTimeString()}.</h2>
        );
        ReactDOM.render(element, document.getElementById('root'));
    }
    setInterval(tick, 1000);
```
3. ### JSX
    JSX Prevents Injection Attacks. By default, React DOM escapes any values embedded in JSX before rendering them, prevent XSS (cross-site-scripting). Babel compiles JSX down to React.createElement() calls. 

```
    function formatName(user) {
        return user.firstName + ' ' + user.lastName;
    }
    const user = {
        firstName: 'Stephen',
        lastName: 'Hawkins'
    };
    const element = (
        <h1>
            Hello, {formatName(user)}!
        </h1>
    );
    ReactDOM.render(
        element,
        document.getElementById('root')
    );

    const element = <img src={user.avatarUrl}></img>;
```
```
const element = (
  <h1 className="greeting">
    Hello, world!
  </h1>
);
const element = React.createElement(
  'h1',
  {className: 'greeting'},
  'Hello, world!'
);
// Note: this structure is simplified
const element = {
  type: 'h1',
  props: {
    className: 'greeting',
    children: 'Hello, world!'
  }
};
```
4. ### Virtual DOM
    “virtual”, representation of a UI is kept in memory and synced with the “real” DOM by a library such as ReactDOM. This process is called reconciliation. “virtual DOM” is usually associated with React elements; React, however, also uses internal objects called “fibers” to hold additional information about the component tree.


5. ### ES5 vs ES6



6. ### Fiber

    *@Andrew Clark: What's Next for React — ReactNext 2016*  
    **Scheduling** allows you to prioritize different kinds of work.
    eg An animation is more important than redux state update.
    eg Update to component not visible on screen, like in ListView.  
    **Concurrency** If we think of React components as func tions,interrupting a React component from rendering means interrupting a function invocation, using generators.  
    1.Interrupt current rendering call stack 2. "Stash" the call stack on side 3. Perform high priority work with its own call stack 4. Go to original call stack and resume.  
    A fiber is virtual stack frame; Saved on heap; unit of concurrency; inspired from OCaml. A fiber has priority, memoized props, key.  
    Browser APis used requestAnimationFrame(cb) and requestIdleCallback(cb). Fiber will also be able to return multiple elements from render.

7. ### Components and Props

    ```
    function Welcome(props) {
        return <h1>Hello, {props.name}</h1>;
    }
    class Welcome extends React.Component {//ES6
        render() {
            return <h1>Hello, {this.props.name}</h1>;
        }
    }
    ```
    The Component Lifecycle: Mounting (constructor(), static getDerivedStateFromProps(), render(). componentDidMount())), Updating (static getDerivedStateFromProps(), shouldComponentUpdate(), render(), getSnapshotBeforeUpdate(), componentDidUpdate()), Unmounting (componentWillUnmount()).

8. ### State
    Lifting State Up: There should be a single “source of truth” for any data that changes in a React application. Usually, the state is first added to the component that needs it for rendering.

```
    class Clock extends React.Component {
    constructor(props) {
        super(props);
        this.state = {date: new Date()};
    }

    componentDidMount() {
        this.timerID = setInterval(
        () => this.tick(),
        1000
        );
    }

    componentWillUnmount() {
        clearInterval(this.timerID);
    }

    tick() {
        this.setState({
        date: new Date()
        });
    }

    render() {
        return (
        <div>
            <h1>Hello, world!</h1>
            <h2>It is {this.state.date.toLocaleTimeString()}.</h2>
        </div>
        );
    }
    }

    ReactDOM.render(
    <Clock />,
        document.getElementById('root')
    );

    // State Updates May Be Asynchronous
    // Correct
    this.setState((state, props) => ({
        counter: state.counter + props.increment
    }));
    // Correct
    this.setState(function(state, props) {
        return {
            counter: state.counter + props.increment
        };
    });
```

9. ### Events
    React events are named using camelCase, rather than lowercase.  
    With JSX you pass a function as the event handler, rather than a string.

10. ### Lists and Keys
    The best way to pick a key is to use a string that uniquely identifies a list item among its siblings.

11. ### Refs and the DOM
    Refs provide a way to access DOM nodes or React elements created in the render method.

12. ### Fragments
    A common pattern in React is for a component to return multiple elements. Fragments let you group a list of children without adding extra nodes to the DOM.
```
class Columns extends React.Component {
  render() {
    return (
      <React.Fragment>
        <td>Hello</td>
        <td>World</td>
      </React.Fragment>
    );
  }
}
class Columns extends React.Component {
  render() {
    return (
      <>
        <td>Hello</td>
        <td>World</td>
      </>
    );
  }
}
function Glossary(props) {  //Keyed Fragment
  return (
    <dl>
      {props.items.map(item => (
        // Without the `key`, React will fire a key warning
        <React.Fragment key={item.id}>
          <dt>{item.term}</dt>
          <dd>{item.description}</dd>
        </React.Fragment>
      ))}
    </dl>
  );
}
```
