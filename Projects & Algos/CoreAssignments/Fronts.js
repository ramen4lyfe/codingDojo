/*
// Add front notes:
class Node {
    constructor(data){
        this.data = data
        this.next = null
    }
}
class LinkedList {
        constructor() {
        this.head = null
    }
    addFront(val) {
        // create a new node ovject with the value provided
        let new_node = new Node(val)
        // checking to seee if the current list does not have a head node (if the list is empty)
        // If the list is empty, place the new node as the head
        if(!this.head) {
            this.head = new_node
            return this
        }
        //if the list is not empty, assign the head to be the next node to the new node 
        new_node.next = this.head
        //then finallly assign the new_node to be the new head of the list
        this.head = new_node
        return this
    }
}
*/

// Challenges
// Add Front: write a methods that accepts a value and create a new node, assign it to the list head, and return a pointer to tne new head node.
// Remove Front: write a method to remove the head node and return the new list head node. If the list is empyty, return null
// Front: write a method to return the value (not the node) at the head of the list, if the list is empty, return null

class Node { // single linked list node class
    constructor(val){
        this.value = val // holds value for this node
        this.next = null // pointer to the next node
    }
}
class LinkedList { // the linked list class
    constructor() { // will start with no nodes
        this.head = null // head points to first node
        // this.tail = null // tails points to nothing
        // this.length = 0
    }

    addFront(val){
        let newNode = new Node(val)
        if(!this.head) {
            this.head = newNode
            return this
        }
        newNode.next = this.head
        this.head = newNode
        return this
    }

    removeFront() {
        if(this.head == null) {
            return this.head
        }
        let removeNode = this.head
        this.head = removeNode.next
        removeNode.next = null
        return this.head
        // if (!this.head)
        // return null

        // if (this.length === 1) {
        //     this.head = null
        //     this.length = 0
        //     return
        // }
        // const currentHead = this.head
        // const newHead = currentHead.next
        // this.head = newHead
        // this.length--
        // return currentHead
    }

    front() {
        if(this.head == null) {
            return this.head
        } else {
            return this.head.value
        }

    }

    
}

const list = new LinkedList()
list.addFront(10)
list.addFront(100)
list.addFront(99)
list.addFront(88)
list.addFront(42)
list.addFront(50)
console.log(list)

list.removeFront()
console.log(list)

console.log(list.front())

