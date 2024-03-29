Angular
=============================================================================================

    is a Javascript framework for constructing SPA(s).

    SPA - Single Page Application
    
     Web-Server                                             Browser
        spa-bundle       <-----------------REQ----------                                   
            index.html  --------RESP (spa-bundle)----------> load the index.html page along with the 
            + .css                                           assosiated .js and .css
            + .js
            + media
                                                            clicking a link/submiting a form or
                                                            any other event is handled by the javascript
                                                            loaded on the client machine.

                                                            in response to the evetn javascript can
                                                            generate html dynamically and update the relevent
                                                            section of the page rather than reloading the entire page.

    db  <---> rest-api  <-------------------REQ------------ Data Operation requests (CRUD) by .js on client
                        -----------------RESP (JSON) ------> json is received by .js and genertes releven html
                                                                and tailors it onto the index page.

    Angular Evolution
    ------------------

        angularjs                   angular library writen in native javascript.
        Angular 2                   angualr libraries are writen in Typescript.
        Angular 4
                5
                6
                7
                .......15


    Typescript?
    ---------------------
        typescript = javascript(ES)  + data-types and variable type safty.

        typescript is not understood by any browser.

        typescript is transpelled (compiled) into javascript before we deploy our app.

        Employee.js                             Employee.ts
         class Employee {                           class Employee{
                                                        empId:number;
                                                        name:string;
                                                        sal:number;

            constrcutor(empId,name,sal){                constrcutor(empId:number,name:string,sal:number){
                this.empId=empId;                           this.empId=empId; 
                this.name=name;                             this.name=name;
                this.sal=sal;                               this.sal=sal;
            }                                           }

            ta(){                                       ta():number{
                return this.sal*0.05;                       return this.sal*0.05;
            }                                           }
         }                                           }

    Angular Archetecture
    ----------------------

        an angular application is made up of a varity of typescript classes. Each angular resource
        is a typescript class marked with a decorator. Each decorator is supplied with a json object
        called meta-data comprising of configuration details.

        Angular Resources

            Module

                    angular module is a unit of code that has to be loaded on to the browser memory.
                    angular modules are different from Javascript modules and they both live side by side.
                    each angular project is contained in a top-level module called 'root-module'.
                    other angular modules are called 'feature-modules'.

                    @NgModule({
                        declarations:[],
                        imports:[],
                        exports:[],
                        providers:[],
                        bootstrap:[]
                    })
                    class SalesModule {}

                    declarations   hold a list of components,pipes and directives that belong to this module.
                    imports        hold a list of feature-modules that are to be imported in the current module.
                    exports        hold a list of components,pipes and directives that belong to this module and are to be exported.
                                   root-module will not have 'exports' section.
                    providers      hold a list of services that belon to the currewnt module 
                    bootstrap      holds a list of top-level components 
                                   root-modules are expected to have 'bootstrap' section.

            Directive

                Angular features html extendability. it means that we can create our own
                elements and attributes in angular.

                Component Directive / Component

                    A component is an extended html element/tag.

                    Component =     STATE,BEHAVIOUR       +       VIEW        +       STYLE
                                        component.ts            component.html          component.css

                    dashboard.component.ts
                            
                            @Component({
                                selector:'dashboard',
                                templateUrl:'dashboard.component.html',
                                stylesUrl:['dashboard.component.css']
                            })
                            class DashboardComponent {
                                webTitle:string;

                                constructor(){
                                    this.webTitle="Vamsy's Exports and Imports";
                                }
                            }

                    dashboard.component.html

                            <h3>{{webTitle}}</h3>
                    
                    dashboard.component.css
                            h3 {
                                border-bottom:1px solid black;
                            }
                    
                    <dashboard></dashbord>

                Attribute Directive

                    An attribute directive is an extended html attribute.
                    
                    @Directive({
                        selector:'fast-moving'
                    })
                    class FastMovingStock {}
                
                    <li fast-moving></li>

                Structural Directive

                    *ngIf
                    *ngFor
                    ngSwitch    *ngSwitchCase *ngDefault

            Pipe

                is used to tranform data just befoer it is rendered.

                in-built:

                    lowercase
                    uppercase
                    titlecase
                    number
                    currency
                    date
                    async
            
                    @Pipe({
                        name:'in-words'
                    })
                    class InWordsPipe {}

            Service

                    @Injectable({
                        providedIn:'root|any'
                    })
                    class SalesService {}
           

    Angular CLI
    ----------------------
        is an angular project structure and management tool.

        it is a javascript tool that runs on NodeJS.

        npm install -g @angular/cli

        ng version

        ng new proj-name            create a new angular project
        ng serve                    bundle the app and host it on a angular live developemnt server @ port 4200
        ng serve -o                 bundle the app and host it on a angular live developemnt server @ port 4200, opens app on browser
        ng serve --port 9999        bundle the app and host it on a angular live developemnt server @ port 9999
        ng serve --port 9999 -o     bundle the app and host it on a angular live developemnt server @ port 9999, opens app on browser
        ng build                    bundle the app and saves the target files in 'dist' folder
        ng test                     bundle the app and execute all test cases (if any)

        ng generate component ComponentName 
        ng g component ComponentName 
        ng g component ComponentName --skip-tests
        ng g c ComponentName --skip-tests
        ng g module ModuleName
        ng g class ClassName --skip-tests
        ng g directive DirectiveName --skip-tests
        ng g pipe PipeName --skip-tests
        ng g service ServiceName --skip-tests
        ng g interface InterfaceName 

    Data Binding
    ----------------------

        the way of accessing the fields and methods of the component class in the component template.

        Interpolation

            will render the value of an expression on to the template.

            syntax:     {{expression}}
            eg1:        {{title}}
            eg2:        {{a+b}}

        Two-Way Data Binding

            is used to write into a form-element value from a field and
            is used to read a form-element value in to a field.

            an inbuilt attrbute directive 'NgModel' from 'FormsModule of @angular/forms' is sued.

            eg: <input type="number" [(ngModel)]="a" />

        One-Way Data Binding
            Attribute Binding

                to bind a field with the attribute of an element.

                syntax: <TagName [attribute]="field" > </TagName>

            Event Binding

                to bind a method to an event attribute directive, so that the method is invoekd as a resposne to
                any event that occurs.

                event attribute directives:
                    click, dblclick, mouseover, mouseleave, mousedown,mouseup, keydown, keyup, keypress,
                    change, blur, focus, ngSubmit

                syntax: <TagName (eventAttribute)="method()"> </TagName>

            Style Binding

                to bind a field to a css-property.

                syntax: <TagName [style.cssProperty]="field" > </TagName>

            Css Class Binding

                to apply or remove a css-class on an element dynamically through a boolean field.

                syntax: <TagName [class.className]="booleanField" > </TagName>
    
    Bootstrap Integration
    -----------------------------------------------------------------------

        npm install bootstrap --save

        add this style sheet to 'styles' section of angular.json
        node_modules/bootstrap/dist/css/bootstrap.min.css

        add this script to 'scripts' section of angular.json
        node_modules/bootstrap/dist/js/bootstrap.min.js

    Routing
    -----------------------------------------------------------------------

        RouterModule        from    '@angular/router'

            Route               {path:'',component:ComponentName,pathMatch:'full|startsWith',children:[]}
            Routes              Route[]
            Router              is a service and offers two methods
                                    navigate()
                                    navigateByUrl()
            ActivatedRoute      is a service offers methods to read url related data like path parameters,
                                port, url ..etc.,
            router-outlet       is a componenet used to hold space for the active component in the
                                top-level-component template.
            routerLink          is a attrubute directive, used on a 'a' tag instead of its 'href' attribute.
            routerLinkActive    is a attribute directive, that takes a css-class to be applied on the active   
                                link.
    
    Typescript interface
    ------------------------------------------------------------------------

        typescript interface can have data memebers / fields.

        this is to provide typesafty for json objects.

        interface Employee{
            empId:number;
            name:string;
            basic:number;
        }

        let e1 = {empId:101,name:'Vamsy',basic:45000};
        let e2 = {empId=102,name:'Bhuvana'};

        e1 is of type Employee, but e2 is not.

    Angular forms
    ------------------------------------------------------------

        Template Driven Forms
                NgModel and NgForm directives from FormsModule

                are constructed directly in the template.
                depend on html 5 validation api and 
                are not responsive in certain validations.

                are not easy to test but easy to construct and mostly emploed
                in case of simple or smaller forms.

        Model-Driven / Reactive Forms
                FormGroup, FormControl classes form ReactiveFormsModule

                are constructed based on a model and bound to the html template.
                are backed up by angular validation api.
                are easy to test and are reliable particularly in larger ad complicated forms.

        Form Control State Properties.

            NgModel and FormControl
                    dirty       prestine
                    touched     untouched
                    invalid     valid

            NgForm and FormGroup
                    invalid     valid

    HttpClient
    -----------------------------------------------------------

        HttpClient  from HttpClientModule   from    '@angular/commons/http'

            HttpClient is a service offering
                get(url) : Observable
                put(url,reqBody) : Observable
                post(url,reqBody) : Observable
                delete(url) : Observable

            Observable from 'rxjs' ; 'ReactiveXJS'

            Observable acts liek a bridge of communication between 
            an asynchronous job and the ui.

            let ob = httpClientObj.get("hhtp://localhost:888/contacts");

            ob.subscribe({
                next: data => { /*doAnythingWiththeData*/ },
                error: err => { /*doSoemthingWithTheError */  }
            });

