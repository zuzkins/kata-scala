package org.codingkata.unit;

import _root_.org.codingkata.unit.api.BaseKataSolution
import api.BaseKataSolution.Day;

class MyKata extends BaseKataSolution {

	trait Payment {
	  val amount: Float
	}

	trait Ticket extends Payment
	case class Regular extends Ticket {
	  val amount = 11.00f
	}
	case class Senior extends Ticket {
	  val amount = 6.00f
	}
	case class Minor extends Ticket {
	  val amount = 5.50f
	}
	case class Student extends Ticket {
	  val amount = 8.00f
	}
	case class Group extends Ticket {
		val amount = 6.00f
	}

	trait Extra extends Payment
	
	case class D3 extends Extra {
	  val amount = 3.00f
	}
	case class OverLength extends Extra {
	  val amount = 1.50f
	}
	case class MovieDay extends Extra {
	  val amount = -2.00f
	}
	case class Weekend extends Extra {
	  val amount = 1.50f
	}
	case class Loge extends Extra {
	  val amount = 2.00f
	}

	case class Customer(age: Int, student: Boolean)
	case class Movie(runtime: Int, day: Day, isParquet: Boolean, is3D: Boolean) {
	  def overLength = runtime > 120
	  def isMovieDay = day == Day.THU
	  def isWeekend = day == Day.SAT || day == Day.SUN
	}

	 var customers: List[Customer] = Nil
	 var movie: Option[Movie] = None

	/**
	 * (1) New customers arrive at your ticket booth and tell you
	 * what movie they'd like to see (so keep it in mind ;-)
	 *
	 * @param runtime       movie's runtime in minutes
	 * @param day           day of the week (enum)
	 * @param isParquet     true if seating category is 'parquet' (and not 'loge')
	 * @param is3D          true if the movie's shown in 3D
	 */
	def startPurchase(runtime : Int, day : Day, isParquet : Boolean, is3D : Boolean) : Unit = {
	  customers = Nil
	  movie = None
	  movie = Some(Movie(runtime, day, isParquet, is3D))
	}

	/**
	 * (2) Add a ticket to the customers' bill
	 *
	 * @param age           the age of the ticket buyer in years
	 * @param isStudent     true if the ticket buyer is a student
	 */
	def addTicket(age : Int, isStudent : Boolean) : Unit = {
		customers = Customer(age, isStudent) :: customers
	}

	/**
	 * (3) Calculate the total admission for the current customer(s)
	 *
	 * @return  total in dollars
	 */
	def finishPurchase() : Float = {
	    val groupSize = customers.size
	    val tickets = customers.map(ticketFor(_, groupSize))
	    val extras = collectExtras(movie.get, groupSize)
	    val extraPrice = extras.foldLeft(0f)(_ + _.amount)*groupSize
	    val ticketPrice = tickets.foldLeft(0f)(_ + _.amount) 


	    println("Tickets: " + ticketPrice + "     extra: " + extraPrice )
	    ticketPrice + extraPrice

	}

	def ticketFor(cust: Customer, groupSize: Int) = (cust, groupSize) match {
 	  case (cust, _) if cust.age < 13 => Minor()
	  case (cust, _) if cust.age > 64 => Senior()
	  case (_, size) if size > 19 => Group()
	  case (cust, _) if cust.student => Student()
	  case (_, _) => Regular()
	}

	def collectExtras(movie: Movie, groupSize: Int): List[Extra] = {
	  val result = scala.collection.mutable.ListBuffer.empty[ Extra ]
	  if (movie.is3D) result += D3()
	  if (movie.overLength)  result += OverLength()
	  if (movie.isMovieDay && groupSize < 20) result += MovieDay()
	  if (movie.isWeekend) result += Weekend()
	  if (!movie.isParquet) result += Loge()
	  result.toList
	}


}
