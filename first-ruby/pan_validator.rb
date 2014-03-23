class PanValidator

  def isValid(pan)

    (/^[0-9]{14,19}$/ =~ pan) != nil
  end

  def luhnCheck(pan)
    digits = pan.to_s.split(//).map {|x| Integer(x)}


    sum = 0
    digits.each { |x| if x.even? sum += x;  else sum += x * 2 end }
    puts sum
    #oddSum = digits.values_at(*digits.each_index.select{|i| (i+1).odd?}).map{|i| i.to_i}.inject{|sum,x| sum + x }
    #evenSum = digits.values_at(*digits.each_index.select{|i| (i+1).even?}).map{|i| i.to_i}.inject{|sum,x| sum + (x * 2) }
    #puts "odds"
    #puts oddSum
    #puts "evens"
    #puts evenSum
    #sum = oddSum + 0
    (sum % 10) == 0
  end

end