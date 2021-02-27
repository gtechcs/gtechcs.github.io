# React
  Based on reactjs.org/docs

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
    All React components must act like pure functions with respect to their props.  
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
```
  class Toggle extends React.Component {
    constructor(props) {
      super(props);
      this.state = {isToggleOn: true};

      // This binding is necessary to make `this` work in the callback
      this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
      this.setState(state => ({
        isToggleOn: !state.isToggleOn
      }));
    }
    //Option 1
    render() {
      return (
        <button onClick={this.handleClick}>
          {this.state.isToggleOn ? 'ON' : 'OFF'}
        </button>
      );
    }
  }

    //Option 2
    // This syntax ensures `this` is bound within handleClick
    // The problem with this syntax is that a different callback is created each time the LoggingButton renders. 
    //  We generally recommend binding in the constructor or using the class fields syntax, to avoid this sort of performance problem.
    handleClick() {
      console.log('this is:', this);
    }
    <button onClick={() => this.handleClick()}>
      Click me
    </button>

  //Option 3
  // public class fields syntax, @babel/plugin-proposal-class-properties
  // This syntax ensures `this` is bound within handleClick.
  // Warning: this is *experimental* syntax.
  // This syntax is enabled by default in Create React App.
  handleClick = () => {
    console.log('this is:', this);
  }
  render() {
    return (
      <button onClick={this.handleClick}>
        Click me
      </button>

```
```
  //Passing arguments
  <button onClick={(e) => this.deleteRow(id, e)}>Delete Row</button>
  <button onClick={this.deleteRow.bind(this, id)}>Delete Row</button>


```
10. ### Lists and Keys
    The best way to pick a key is to use a string that uniquely identifies a list item among its siblings.
```
  function NumberList(props) {
    const numbers = props.numbers;
    return (
      <ul>
        {numbers.map((number) =>
          <ListItem key={number.toString()}
                    value={number} />
        )}
      </ul>
    );
  }
```
11. ### Forms
    Controlled Components: React state be the “single source of truth”. An input form element whose value is controlled by React.



12. ### Refs and the DOM
    Refs provide a way to access DOM nodes or React elements created in the render method.

13. ### Fragments
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
14. ### Lazy Loading
```
  import React, { Suspense, lazy } from 'react';
  import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

  const Home = lazy(() => import('./routes/Home'));
  const About = lazy(() => import('./routes/About'));

  const App = () => (
    <Router>
      <Suspense fallback={<div>Loading...</div>}>
        <Switch>
          <Route exact path="/" component={Home}/>
          <Route path="/about" component={About}/>
        </Switch>
      </Suspense>
    </Router>
  );

```
15. ### Context
```
  // Context lets us pass a value deep into the component tree
  // without explicitly threading it through every component.
  // Create a context for the current theme (with "light" as the default).
  const ThemeContext = React.createContext('light');

  class App extends React.Component {
    render() {
      // Use a Provider to pass the current theme to the tree below.
      // Any component can read it, no matter how deep it is.
      // In this example, we're passing "dark" as the current value.
      return (
        <ThemeContext.Provider value="dark">
          <Toolbar />
        </ThemeContext.Provider>
      );
    }
  }
  // A component in the middle doesn't have to
  // pass the theme down explicitly anymore.
  function Toolbar() {
    return (
      <div>
        <ThemedButton />
      </div>
    );
  }
  class ThemedButton extends React.Component {
    // Assign a contextType to read the current theme context.
    // React will find the closest theme Provider above and use its value.
    // In this example, the current theme is "dark".
    static contextType = ThemeContext;
    render() {
      return <Button theme={this.context} />;
    }
  }
```
16. ### Error Doundary
```
  class ErrorBoundary extends React.Component {
    constructor(props) {
      super(props);
      this.state = { hasError: false };
    }

    static getDerivedStateFromError(error) {
      // Update state so the next render will show the fallback UI.
      return { hasError: true };
    }

    componentDidCatch(error, errorInfo) {
      // You can also log the error to an error reporting service
      logErrorToMyService(error, errorInfo);
    }

    render() {
      if (this.state.hasError) {
        // You can render any custom fallback UI
        return <h1>Something went wrong.</h1>;
      }

      return this.props.children; 
    }
  }
```
17. ### Refs and Forwarding refs
  Refs provide a way to access DOM nodes or React elements created in the render method.
  Used for managing focus, text selection, or media playback.

```
    class AutoFocusTextInput extends React.Component {
      constructor(props) {
        super(props);
        this.textInput = React.createRef();
      }

      componentDidMount() {
        this.textInput.current.focusTextInput();
      }

      render() {
        return (
          <CustomTextInput ref={this.textInput} />
        );
      }
    }
```
18. ### Higher Order Components
    A higher-order component is a function that takes a component and returns a new component.
```
    const CommentListWithSubscription = withSubscription(
      CommentList,
      (DataSource) => DataSource.getComments()
    );

    const BlogPostWithSubscription = withSubscription(
      BlogPost,
      (DataSource, props) => DataSource.getBlogPost(props.id)
    );
```
    Don’t Mutate the Original Component. Use Composition.  
    Convention: Pass Unrelated Props Through to the Wrapped Component  
    Convention: Maximizing Composability  
    Convention: Wrap the Display Name for Easy Debugging  
    Don’t Use HOCs Inside the render Method  
    Static Methods Must Be Copied Over  
    Refs Aren’t Passed Through

19. ### Integrating with Other Libraries


20. ### Optimizing Performance
    Use the Production Build  
    





