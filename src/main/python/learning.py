# various imports

# import cv2 as cv
# import pyautogui as auto
from toolz import *
from dataclasses import dataclass
# move mouse
# auto.moveTo(100, 100, 5, auto.easeInCubic)
from multipledispatch import dispatch

#### DESTRUCTURING ####

# destructuring in a tuple
# a,b = (1,2)
# print(a,b)

# destructuring in a list
# a,b,c = [1,2,3]
# print(a,b,c)

# destructuring in a dictionary
# a,b,c = {'a':1,'b':2,'c':3}
# print(a,b,c)

# destructuring in a set
# a,b,c = {1,2,3}
# print(a,b,c)

# destructuring in a string
# a,b,c = "abc"
# print(a,b,c)

# destructuring in a function... this returns as a tuple
# def f(a,b,c):
#     return a,b,c

# a,b,c = f(1,2,3)

# destructuring in a for loop

# for a,b,c in [(1,2,3),(4,5,6),(7,8,9)]:
#     print(a,b,c)

# entities = [
# 	("Gobby", 42, "Shaman"),
# 	("Julius", 24, "Bard"),
# 	("Harry", 999, "Weezard")
# ]

# for name, lvl, clazz in entities:
# 	print(f"Name: {name}, Level: {lvl}, Class: {clazz}")



# head, *tail = [1, 2, 3, 4, 5]

# print(head)  # 1
# print(tail)  # [2, 3, 4, 5]

# *all_but_last, last = [1, 2, 3, 4, 5]

# print(all_but_last)  # [1, 2, 3, 4]
# print(last)  # 5

# head, *middle, tail = [1, 2, 3, 4, 5]

# print(head)    # 1
# print(middle)  # [2, 3, 4]
# print(tail)    # 5

#### ANONYMOUS VARIABLES ####
# who cares variable/argument 

# a, _, b = (1,2,3)
# print(f"I only care about {a} and {b}") 

#### KEYWORD ARGUMENTS ####

# keyword arguments
# multiple arity
# dynamic typing vs static typing
# optional types or type hinting

#  DATACLASSES
# @dataclass
# class Entity:
#     health: int
#     attack: int

# @dataclass
# class Actions:
#     kek: int

# # data is inherited from right to left so you have to instantiate health and attack before kek 
# @dataclass
# class Person(Actions,Entity):
#     name: str
#     age: int
#     job: str

# person = Person(100,100,"John", 30, "Engineer", "dsad") # constructor takes in all values from superclasses
# print(person)

#### PATTERN MATCHING ####

# @dataclass
# class Person:
#     name: str
#     age: int
#     job: str
# person = Person("John", 30, "Engineer")
# match person:
#     case Person(name="John", age=25): # can use positional arguments or keyword arguments for matching
#         print("John is 25")
#     case Person(name="John", age=30):
#         print("John is 30")
#     case Person("John", 30, "Engineer"): # does not execute because it is shadowed above
#         print("John is 30 and Engineer")
#     case Person:
#         print("Person")

#### ASSIGNMENT EXPRESSIONS ####
# x = 0
# while (x := x + 1) < 10:
#     print(x)


####  POSITIONAL ARGUMENTS VS KEYWORD ARGUMENTS ####
def f(a, b, c):
    print(a, b, c)

def g(a=1, b=2, c=3):
    print(a, b, c)

def h(a, b=2, c=3):
    print(a, b, c)

def i(a=1, b=2, **kwarg):
    print(a, b, kwarg)

i(1, 2, c=3, d=4)

# list comprehensions
print([x*2 for x in [1,2,3]])
# decorators
# TODO you are here!!!


#### STRING SLICING AND FORMATTING #### 
# syntax is like this [from:to-1:step] or [-from + 1:-to:-step]
# notes: each {} means to skip or omit

# start at 1, end at 5, step by 2
# print("abcdefghijkl"[1:5:2]) # "{a}b{c}d{efghijkl}" 

# you can omit portions of the slice skip each other character in a string
# print("abcdefghijkl"[::2]) # "a{b}c{d}e{f}g{h}i{j}k" 

# iterates backwards so it returns lkj
# print("abcdefghijkl"[-1:-4:-1]) # "{abcdefghi}jkl" 

# a,b,c = (1,2,3) # the string below is an example of interpolation/formatting
# print(f"{a} {b} {c}") # prints 1 2 3

#  object reorientation, multiple inheritance and multiple dispatch

# create an Actions class, this will determine what other classes can take actions
class Actions():
    pass

#  create an entity class, this is the base class of all other classes in our short tour
@dataclass
class Entity():
    health: int
    attack: int

#  define a goblin class which inherits from Actions and Entity
class Goblin(Actions, Entity):
    pass

# create a human class which inherits from Entity
class Human(Entity):
    pass

#  define what to attack on outside of the objects themselves
@dispatch(Actions,Entity)
def attack(entity_that_can_attack: Actions, entity: Entity):
    entity.health -= entity_that_can_attack.attack
    print("{} destroys nub OHHHH your fu#$^d now is {}".format(entity_that_can_attack.__class__.__name__, entity.health))

#  print out a goblin attacking a human
attack(Goblin(100, 35), Human(100, 10))

# what is the difference between multiple dispatch and overloading?
# void add(Foo o) { ... }
# void add(Bar o) { ... }
# void client() {
#     Foo o = new Bar();
#     add(o); // calls add(Foo) not add(Bar)!
# }
# using multiple dispatch however

# void add(Foo o) { o.dispatch(this); }
# void add(Bar o) { o.dispatch(this); }
# void client() {
#     Foo o = new Bar();
#     add(o); // calls #dispatch as defined in Bar!
# }

#  generators which are basically just coroutines
# def fib():
#     prev,next = 0,1
#     while True:
#         yield prev
#         prev,next = next,prev+next

# fib_gen = fib()
# for i in range(10):
#     print(next(fib_gen))

