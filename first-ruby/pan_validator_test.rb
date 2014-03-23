require 'test/unit'
require_relative 'pan_validator'

class PanValidatorTest < Test::Unit::TestCase

  def setup
  end

  def teardown
  end

  def test_digits_only
    assert !PanValidator.new().isValid("abc")
    assert !PanValidator.new().isValid("1a")
    assert PanValidator.new().isValid("12345678901234")
  end

  def test_length
    assert !PanValidator.new().isValid("123")
    assert PanValidator.new().isValid("12345678901234")
    assert !PanValidator.new().isValid("12345678901234567890")
  end

  def test_luhn_check
    assert !PanValidator.new().luhnCheck("124")
  end


end